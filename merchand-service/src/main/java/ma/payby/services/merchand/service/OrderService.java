package ma.payby.services.merchand.service;

import ma.payby.common.dto.*;
import ma.payby.common.exception.BusinessException;
import ma.payby.common.jpa.model.Merchand;
import ma.payby.common.jpa.model.Order;
import ma.payby.common.jpa.model.Paiement;
import ma.payby.common.jpa.repository.MerchandRepository;
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
    private MerchandRepository merchandRepository;

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

    public List<OrderDTO> getAllOrder() throws BusinessException {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOList = orders.stream()
                .map(e -> OrderMapper.toOrderDTO(e)).collect(Collectors.toList());
        return orderDTOList;
    }

    public InitierPaymentMerchandResponseDTO addOrder(InitierPaymentMerchandRequestDTO initierPaymentMerchandRequestDTO) throws BusinessException{
        Merchand merchand = merchandRepository.findByUserName(initierPaymentMerchandRequestDTO.getMerchandUserName());
            if(merchand == null)
                throw new BusinessException("M00001",CommonUtils.ERROR_BUSINESS.get("M00001"));
        validateOrderCreation(merchand,initierPaymentMerchandRequestDTO);
        Order savedOrder = orderRepository.save(OrderMapper.toOrder(initierPaymentMerchandRequestDTO,merchand));
            if(savedOrder == null)
                throw new BusinessException("M00005",CommonUtils.ERROR_BUSINESS.get("M00005"));
        InitierPaymentMerchandResponseDTO initierPaymentMerchandResponseDTO = new InitierPaymentMerchandResponseDTO();
        initierPaymentMerchandResponseDTO.setMerchandOrderID(savedOrder.getMerchandOrderID());
        initierPaymentMerchandResponseDTO.setMerchandUserName(savedOrder.getMerchand().getUserName());
        initierPaymentMerchandResponseDTO.setOrderReference(savedOrder.getReference());
        initierPaymentMerchandResponseDTO.setRedirectionURL(savedOrder.getMerchand().getPaybyRedirectionURL());
        initierPaymentMerchandResponseDTO.setVersionPayby(savedOrder.getMerchand().getPaybyVersion());
        initierPaymentMerchandResponseDTO.setTrackID(savedOrder.getReference());
        initierPaymentMerchandResponseDTO.setResponseCode("0");
        return initierPaymentMerchandResponseDTO;
    }

    public OrderDTO editStatutOrder(OrderEditStatusRequestDTO orderEditStatusRequestDTO) throws BusinessException{
        Order order = orderRepository.findByOrderID(orderEditStatusRequestDTO.getId());
        if(order==null)
            throw new BusinessException("M00002", CommonUtils.ERROR_BUSINESS.get("M00002"));
        order.setOrderStatus(orderEditStatusRequestDTO.getOrderStatus());
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.toOrderDTO(savedOrder);
    }

    private void validateOrderCreation(Merchand merchand,InitierPaymentMerchandRequestDTO initierPaymentMerchandRequestDTO)
            throws BusinessException{
        StringBuilder data = new StringBuilder();
        String signature="";
        data.append(merchand.getPaybyVersion())
                .append(merchand.getUserName())
                .append(initierPaymentMerchandRequestDTO.getAmount())
                .append(initierPaymentMerchandRequestDTO.getOrderID())
                .append(initierPaymentMerchandRequestDTO.getOrderDetails())
                .append(merchand.getMerchandResponseURL())
                .append(initierPaymentMerchandRequestDTO.getCustomerLastName())
                .append(initierPaymentMerchandRequestDTO.getCustomerfirstName())
                .append(initierPaymentMerchandRequestDTO.getCustomerAdress())
                .append(initierPaymentMerchandRequestDTO.getCodePostal())
                .append(initierPaymentMerchandRequestDTO.getVille())
                .append(initierPaymentMerchandRequestDTO.getPays())
                .append(initierPaymentMerchandRequestDTO.getPhoneNumber())
                .append(initierPaymentMerchandRequestDTO.getEmail())
                .append(merchand.getMerchandResponseURL());

        try {
            signature = SignatureUtils.encode(merchand.getSecretKey(),data.toString());
        } catch (NoSuchAlgorithmException |
                UnsupportedEncodingException | InvalidKeyException e) {
            throw new BusinessException("T00001", CommonUtils.ERROR_BUSINESS.get("T00001"));

        }
        if(!signature.toUpperCase().equals(initierPaymentMerchandRequestDTO.getSignature()))
            throw new BusinessException("M00006", CommonUtils.ERROR_BUSINESS.get("M00006"));

    }
}
