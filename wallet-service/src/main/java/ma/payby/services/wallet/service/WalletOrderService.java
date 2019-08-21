package ma.payby.services.wallet.service;

import ma.payby.common.dto.*;
import ma.payby.common.enums.OrderStatus;
import ma.payby.common.exception.BusinessException;
import ma.payby.common.jpa.model.Paiement;
import ma.payby.common.jpa.repository.PaimentRepository;
import ma.payby.common.service.mapper.OrderMapper;
import ma.payby.common.service.mapper.PaiementMapper;
import ma.payby.common.utils.CommonUtils;
import ma.payby.common.utils.SignatureUtils;
import ma.payby.services.wallet.client.MerchandClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class WalletOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WalletOrderService.class);
    @Autowired
    MerchandClient merchandClient;

    @Autowired
    PaimentRepository paimentRepository;

    public OrderWalletResponseDTO getOrderForPayment(String reference) throws BusinessException {
        OrderWalletResponseDTO orderWalletResponseDTO = new OrderWalletResponseDTO();
        OrderDTO orderDTO =merchandClient.findOrderByReference(reference);
        if(orderDTO==null)
            throw new BusinessException("M00002", CommonUtils.ERROR_BUSINESS.get("M00002"));
        else if (OrderStatus.CAPTURED.equals(orderDTO.getOrderStatus()))
            throw new BusinessException("M00003", CommonUtils.ERROR_BUSINESS.get("M00003"));
        else if (OrderStatus.EXPIRE.equals(orderDTO.getOrderStatus()))
            throw new BusinessException("M00004", CommonUtils.ERROR_BUSINESS.get("M00004"));
        else if (OrderStatus.REFUSE.equals(orderDTO.getOrderStatus()))
            throw new BusinessException("M00004", CommonUtils.ERROR_BUSINESS.get("M00004"));

        return OrderMapper.toOrderWalletResponseDTO(orderDTO);

    }

    public PaiementDTO confirmPayment(ConfirmPaymentWalletRequestDTO confirmPaymentWalletRequestDTO) throws BusinessException{
        PaiementDTO paiementDTO = new PaiementDTO();
        if(!validateWalletRequest(confirmPaymentWalletRequestDTO))
            throw new BusinessException("W00001",CommonUtils.ERROR_BUSINESS.get("W00001"));
        else {
            OrderDTO orderDTO = merchandClient.findOrderByReference(confirmPaymentWalletRequestDTO.getRefernece());
           if(orderDTO ==null)
            throw new BusinessException("M00002", CommonUtils.ERROR_BUSINESS.get("M00002"));

            OrderEditStatusRequestDTO orderEditStatusRequestDTO = new OrderEditStatusRequestDTO(orderDTO.getOrderID(), confirmPaymentWalletRequestDTO.getOrderStatus());
            merchandClient.editOrderStatus(orderEditStatusRequestDTO);
            Paiement paiement = new Paiement();
            paiement.setDateStatus(confirmPaymentWalletRequestDTO.getDateStatut());
            paiement.setOrderStatus(confirmPaymentWalletRequestDTO.getOrderStatus());
            paiement.setOrder(OrderMapper.toOrder(orderDTO));
            paimentRepository.save(paiement);
            ConfirmPaymentMerchandRequestDTO confirmPaymentMerchandRequestDTO = OrderMapper.toConfirmPaymentMerchandRequestDTO(orderDTO,paiement.getDateStatus(),paiement.getOrderStatus());
            confirmPaymentMerchandRequestDTO.setSignature(generateMerchandConfirmationSignature(confirmPaymentMerchandRequestDTO,paiement));
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<ConfirmPaymentMerchandRequestDTO> request = new HttpEntity<>(confirmPaymentMerchandRequestDTO, headers);
            LOGGER.info("Call Api Site merchand url: " +orderDTO.getMerchand().getMerchandResponseURL());
            ResponseEntity<String> response = restTemplate.postForEntity( orderDTO.getMerchand().getMerchandResponseURL(), request , String.class );
            LOGGER.info("Response Api Site merchand" +response.toString());
            paiementDTO = PaiementMapper.toPaiementDTO(paiement);
        }

        return paiementDTO;
    }


    private boolean validateWalletRequest(ConfirmPaymentWalletRequestDTO confirmPaymentWalletRequestDTO) {
        // Add verification rules
        if(confirmPaymentWalletRequestDTO.getSignature()==null)
            return false;
        return true;
    }


    private String generateMerchandConfirmationSignature(ConfirmPaymentMerchandRequestDTO confirmPaymentMerchandRequestDTO,
                                                         Paiement paiement) throws BusinessException {
        StringBuilder data = new StringBuilder();
        String signature="";
        data.append(confirmPaymentMerchandRequestDTO.getPaybyVersion())
                .append(paiement.getOrder().getMerchand().getUserName())
                .append(paiement.getOrder().getReference())
                .append(confirmPaymentMerchandRequestDTO.getCode())
                .append(confirmPaymentMerchandRequestDTO.getMessage())
                .append(paiement.getOrder().getMerchandOrderID())
                .append(paiement.getOrder().getAmount().setScale(2, RoundingMode.HALF_UP).stripTrailingZeros())
                .append(paiement.getOrderStatus());

        try {
            signature = SignatureUtils.encode(paiement.getOrder().getMerchand().getSecretKey(),data.toString());
        } catch (NoSuchAlgorithmException |
                UnsupportedEncodingException | InvalidKeyException e) {
            throw new BusinessException("T00001", CommonUtils.ERROR_BUSINESS.get("T00001"));

        }

        return signature;
    }

}
