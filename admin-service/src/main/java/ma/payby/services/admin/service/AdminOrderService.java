package ma.payby.services.admin.service;

import ma.payby.common.dto.OrderDTO;
import ma.payby.common.dto.OrderEditStatusRequestDTO;
import ma.payby.common.exception.BusinessException;
import ma.payby.common.jpa.model.Order;
import ma.payby.common.jpa.repository.OrderRepository;
import ma.payby.common.service.mapper.OrderMapper;
import ma.payby.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdminOrderService {
    @Autowired
    private OrderRepository orderRepository;

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
        List<Order> merchants = orderRepository.findAll();
        List<OrderDTO> orderDTOList = merchants.stream()
                .map(e ->OrderMapper.toOrderDTO(e)).collect(Collectors.toList());
        return orderDTOList;
    }

    public OrderDTO addOrder(OrderDTO orderDTO){
        Order savedOrder = orderRepository.save(OrderMapper.toOrder(orderDTO));
        return OrderMapper.toOrderDTO(savedOrder);
    }

    public OrderDTO editStatutOrder(OrderEditStatusRequestDTO orderEditStatusRequestDTO) throws BusinessException{
        Order order = orderRepository.findByOrderID(orderEditStatusRequestDTO.getId());
        if(order==null)
            throw new BusinessException("M00002", CommonUtils.ERROR_BUSINESS.get("M00002"));
        order.setOrderStatus(orderEditStatusRequestDTO.getOrderStatus());
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.toOrderDTO(savedOrder);
    }
}
