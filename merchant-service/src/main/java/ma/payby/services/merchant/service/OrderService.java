package ma.payby.services.merchant.service;

import ma.payby.common.dto.*;
import ma.payby.common.enums.OrderStatus;
import ma.payby.common.exception.BusinessException;
import ma.payby.common.jpa.model.Merchant;
import ma.payby.common.jpa.model.Order;
import ma.payby.common.jpa.model.Paiement;
import ma.payby.common.jpa.repository.MerchantRepository;
import ma.payby.common.jpa.repository.OrderRepository;
import ma.payby.common.service.mapper.OrderMapper;
import ma.payby.common.utils.CommonUtils;
import ma.payby.common.utils.SignatureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    public OrderDTO getOrderById(Long id) throws BusinessException {
        Order order = orderRepository.findByOrderID(id);
        if(order == null)
            throw new BusinessException("M00002", CommonUtils.ERROR_BUSINESS.get("M00002"));
        return OrderMapper.toOrderDTO(order);
    }

    public OrderDTO getOrderByReference(String reference) throws BusinessException {
        Order order = orderRepository.findByReference(reference);
        if(order == null)
            throw new BusinessException("M00002", CommonUtils.ERROR_BUSINESS.get("M00002"));

        return OrderMapper.toOrderDTO(order);
    }

    public OrderStatus getOrderStatusByReference(String reference) throws BusinessException {
        Order order = orderRepository.findByReference(reference);
        if(order == null)
            throw new BusinessException("M00002", CommonUtils.ERROR_BUSINESS.get("M00002"));

        return order.getOrderStatus();
    }

    public List<OrderDTO> getAllOrder() throws BusinessException {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOList = orders.stream()
                .map(e -> OrderMapper.toOrderDTO(e)).collect(Collectors.toList());
        return orderDTOList;
    }

    public InitierPaymentMerchantResponseDTO addOrder(InitierPaymentMerchantRequestDTO initierPaymentMerchantRequestDTO) throws BusinessException{
        Merchant merchant = merchantRepository.findByUserName(initierPaymentMerchantRequestDTO.getMerchantUserName());
            if(merchant == null)
                throw new BusinessException("M00001",CommonUtils.ERROR_BUSINESS.get("M00001"));
        validateOrderCreation(merchant,initierPaymentMerchantRequestDTO);
        Order savedOrder = orderRepository.save(OrderMapper.toOrder(initierPaymentMerchantRequestDTO,merchant));
            if(savedOrder == null)
                throw new BusinessException("M00005",CommonUtils.ERROR_BUSINESS.get("M00005"));
        InitierPaymentMerchantResponseDTO initierPaymentMerchantResponseDTO = new InitierPaymentMerchantResponseDTO();
        initierPaymentMerchantResponseDTO.setMerchantOrderID(savedOrder.getMerchantOrderID());
        initierPaymentMerchantResponseDTO.setMerchantUserName(savedOrder.getMerchant().getUserName());
        initierPaymentMerchantResponseDTO.setOrderReference(savedOrder.getReference());
        initierPaymentMerchantResponseDTO.setRedirectionURL(savedOrder.getMerchant().getPaybyRedirectionURL());
        initierPaymentMerchantResponseDTO.setVersionPayby(savedOrder.getMerchant().getPaybyVersion());
        initierPaymentMerchantResponseDTO.setTrackID(savedOrder.getReference());
        initierPaymentMerchantResponseDTO.setResponseCode("0");
        return initierPaymentMerchantResponseDTO;
    }

    public OrderDTO editStatutOrder(OrderEditStatusRequestDTO orderEditStatusRequestDTO) throws BusinessException{
        Order order = orderRepository.findByOrderID(orderEditStatusRequestDTO.getId());
        if(order==null)
            throw new BusinessException("M00002", CommonUtils.ERROR_BUSINESS.get("M00002"));
        order.setOrderStatus(orderEditStatusRequestDTO.getOrderStatus());
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.toOrderDTO(savedOrder);
    }

    private void validateOrderCreation(Merchant merchant,InitierPaymentMerchantRequestDTO initierPaymentMerchantRequestDTO)
            throws BusinessException{
        StringBuilder data = new StringBuilder();
        String signature="";
        data.append(merchant.getPaybyVersion())
                .append(merchant.getUserName())
                .append(initierPaymentMerchantRequestDTO.getAmount())
                .append(initierPaymentMerchantRequestDTO.getOrderID())
                .append(initierPaymentMerchantRequestDTO.getOrderDetails())
                .append(merchant.getMerchantResponseURL())
                .append(initierPaymentMerchantRequestDTO.getCustomerLastName())
                .append(initierPaymentMerchantRequestDTO.getCustomerfirstName())
                .append(initierPaymentMerchantRequestDTO.getCustomerAdress())
                .append(initierPaymentMerchantRequestDTO.getCodePostal())
                .append(initierPaymentMerchantRequestDTO.getVille())
                .append(initierPaymentMerchantRequestDTO.getPays())
                .append(initierPaymentMerchantRequestDTO.getPhoneNumber())
                .append(initierPaymentMerchantRequestDTO.getEmail())
                .append(merchant.getMerchantResponseURL());

        try {
            signature = SignatureUtils.encode(merchant.getSecretKey(),data.toString());
        } catch (NoSuchAlgorithmException |
                UnsupportedEncodingException | InvalidKeyException e) {
            throw new BusinessException("T00001", CommonUtils.ERROR_BUSINESS.get("T00001"));

        }
        if(!signature.toUpperCase().equals(initierPaymentMerchantRequestDTO.getSignature()))
            throw new BusinessException("M00006", CommonUtils.ERROR_BUSINESS.get("M00006"));

    }
}
