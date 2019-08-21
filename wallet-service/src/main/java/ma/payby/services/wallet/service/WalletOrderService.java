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
import ma.payby.services.wallet.client.MerchantClient;
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
    MerchantClient merchantClient;

    @Autowired
    PaimentRepository paimentRepository;

    public OrderWalletResponseDTO getOrderForPayment(String reference) throws BusinessException {
        OrderWalletResponseDTO orderWalletResponseDTO = new OrderWalletResponseDTO();
        OrderDTO orderDTO =merchantClient.findOrderByReference(reference);
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
            OrderDTO orderDTO = merchantClient.findOrderByReference(confirmPaymentWalletRequestDTO.getReference());
           if(orderDTO ==null)
            throw new BusinessException("M00002", CommonUtils.ERROR_BUSINESS.get("M00002"));

            OrderEditStatusRequestDTO orderEditStatusRequestDTO = new OrderEditStatusRequestDTO(orderDTO.getOrderID(), confirmPaymentWalletRequestDTO.getOrderStatus());
            merchantClient.editOrderStatus(orderEditStatusRequestDTO);
            Paiement paiement = new Paiement();
            paiement.setDateStatus(confirmPaymentWalletRequestDTO.getDateStatut());
            paiement.setOrderStatus(confirmPaymentWalletRequestDTO.getOrderStatus());
            paiement.setOrder(OrderMapper.toOrder(orderDTO));
            paimentRepository.save(paiement);
            ConfirmPaymentMerchantRequestDTO confirmPaymentMerchantRequestDTO = OrderMapper.toConfirmPaymentMerchantRequestDTO(orderDTO,paiement.getDateStatus(),paiement.getOrderStatus());
            confirmPaymentMerchantRequestDTO.setSignature(generateMerchantConfirmationSignature(confirmPaymentMerchantRequestDTO,paiement));
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<ConfirmPaymentMerchantRequestDTO> request = new HttpEntity<>(confirmPaymentMerchantRequestDTO, headers);
            LOGGER.info("Call Api Site merchant url: " +orderDTO.getMerchant().getMerchantResponseURL());
            ResponseEntity<String> response = restTemplate.postForEntity( orderDTO.getMerchant().getMerchantResponseURL(), request , String.class );
            LOGGER.info("Response Api Site merchant" +response.toString());
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


    private String generateMerchantConfirmationSignature(ConfirmPaymentMerchantRequestDTO confirmPaymentMerchantRequestDTO,
                                                         Paiement paiement) throws BusinessException {
        StringBuilder data = new StringBuilder();
        String signature="";
        data.append(confirmPaymentMerchantRequestDTO.getPaybyVersion())
                .append(paiement.getOrder().getMerchant().getUserName())
                .append(paiement.getOrder().getReference())
                .append(confirmPaymentMerchantRequestDTO.getCode())
                .append(confirmPaymentMerchantRequestDTO.getMessage())
                .append(paiement.getOrder().getMerchantOrderID())
                .append(paiement.getOrder().getAmount().setScale(2, RoundingMode.HALF_UP).stripTrailingZeros())
                .append(paiement.getOrderStatus());

        try {
            signature = SignatureUtils.encode(paiement.getOrder().getMerchant().getSecretKey(),data.toString());
        } catch (NoSuchAlgorithmException |
                UnsupportedEncodingException | InvalidKeyException e) {
            throw new BusinessException("T00001", CommonUtils.ERROR_BUSINESS.get("T00001"));

        }

        return signature;
    }

}
