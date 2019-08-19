package ma.payby.common.service.mapper;

import ma.payby.common.dto.*;
import ma.payby.common.enums.OrderStatus;
import ma.payby.common.jpa.model.Customer;
import ma.payby.common.jpa.model.Merchand;
import ma.payby.common.jpa.model.Order;
import ma.payby.common.utils.CommonUtils;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class OrderMapper {
    public static OrderDTO toOrderDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order,orderDTO);

        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(order.getCustomer(),customerDTO);
        orderDTO.setCustomer(customerDTO);
        orderDTO.setMerchand(MerchandMapper.toMerchandDTO(order.getMerchand()));

        return orderDTO;
    }

    public static Order toOrder(OrderDTO orderDTO){
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);
        Customer customer = new Customer();
        BeanUtils.copyProperties(orderDTO.getCustomer(),customer);

        order.setCustomer(customer);
        order.setMerchand(MerchandMapper.toMerchand(orderDTO.getMerchand()));
        return order;
    }

    public static Order toOrder(InitierPaymentMerchandRequestDTO initierPaymentMerchandRequestDTO, Merchand merchand){
        Order order = new Order();
        Customer customer = new Customer();
        customer.setAddress(initierPaymentMerchandRequestDTO.getCustomerAdress());
        customer.setCodePostal(initierPaymentMerchandRequestDTO.getCodePostal());
        customer.setEmail(initierPaymentMerchandRequestDTO.getEmail());
        customer.setLastName(initierPaymentMerchandRequestDTO.getCustomerLastName());
        customer.setFirstName(initierPaymentMerchandRequestDTO.getCustomerfirstName());
        customer.setPhoneNumber(initierPaymentMerchandRequestDTO.getPhoneNumber());
        customer.setVille(initierPaymentMerchandRequestDTO.getVille());
        customer.setPaye(initierPaymentMerchandRequestDTO.getPays());
        order.setCustomer(customer);
        order.setMerchand(merchand);
        order.setOrderStatus(OrderStatus.ENATTENTE);
        order.setAmount(initierPaymentMerchandRequestDTO.getAmount());
        order.setOrderDetails(initierPaymentMerchandRequestDTO.getOrderDetails());
        order.setCreationDate(new Date());
        order.setMerchandOrderID(initierPaymentMerchandRequestDTO.getOrderID());
        order.setReference(CommonUtils.generateReference());

        return order;
    }

    public static OrderWalletResponseDTO toOrderWalletResponseDTO(OrderDTO orderDTO){
        OrderWalletResponseDTO orderWalletResponseDTO = new OrderWalletResponseDTO();
        orderWalletResponseDTO.setAmount(orderDTO.getAmount());
        orderWalletResponseDTO.setMerchandName(orderDTO.getMerchand().getName());
        orderWalletResponseDTO.setMerchandNumber(orderDTO.getMerchand().getMobileNumber());
        orderWalletResponseDTO.setOrderStatus(orderDTO.getOrderStatus());
        orderWalletResponseDTO.setOrderDetails(orderDTO.getOrderDetails());
        return orderWalletResponseDTO;
    }

    public static ConfirmPaymentMerchandRequestDTO toConfirmPaymentMerchandRequestDTO(OrderDTO orderDTO, Date dateStatus, OrderStatus orderStatus){
        ConfirmPaymentMerchandRequestDTO confirmPaymentMerchandRequestDTO = new ConfirmPaymentMerchandRequestDTO();
        confirmPaymentMerchandRequestDTO.setAmount(orderDTO.getAmount());
        confirmPaymentMerchandRequestDTO.setCode("01");
        confirmPaymentMerchandRequestDTO.setMessage("success");
        confirmPaymentMerchandRequestDTO.setMerchandUserName(orderDTO.getMerchand().getUserName());
        confirmPaymentMerchandRequestDTO.setOrderID(orderDTO.getMerchandOrderID());
        confirmPaymentMerchandRequestDTO.setPaybyVersion("PayByVesrion");
        confirmPaymentMerchandRequestDTO.setRefernece(orderDTO.getReference());
        confirmPaymentMerchandRequestDTO.setTransactionDate(dateStatus);
        confirmPaymentMerchandRequestDTO.setStatus(orderStatus);
        confirmPaymentMerchandRequestDTO.setSignature("hhhhhhhh");
        return confirmPaymentMerchandRequestDTO;
    }


}
