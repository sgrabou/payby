package ma.payby.common.service.mapper;

import ma.payby.common.dto.*;
import ma.payby.common.enums.OrderStatus;
import ma.payby.common.jpa.model.Customer;
import ma.payby.common.jpa.model.Merchant;
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
        orderDTO.setMerchant(MerchantMapper.toMerchantDTO(order.getMerchant()));

        return orderDTO;
    }

    public static Order toOrder(OrderDTO orderDTO){
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);
        Customer customer = new Customer();
        BeanUtils.copyProperties(orderDTO.getCustomer(),customer);

        order.setCustomer(customer);
        order.setMerchant(MerchantMapper.toMerchant(orderDTO.getMerchant()));
        return order;
    }

    public static Order toOrder(InitierPaymentMerchantRequestDTO initierPaymentMerchantRequestDTO, Merchant merchant){
        Order order = new Order();
        Customer customer = new Customer();
        customer.setAddress(initierPaymentMerchantRequestDTO.getCustomerAdress());
        customer.setCodePostal(initierPaymentMerchantRequestDTO.getCodePostal());
        customer.setEmail(initierPaymentMerchantRequestDTO.getEmail());
        customer.setLastName(initierPaymentMerchantRequestDTO.getCustomerLastName());
        customer.setFirstName(initierPaymentMerchantRequestDTO.getCustomerfirstName());
        customer.setPhoneNumber(initierPaymentMerchantRequestDTO.getPhoneNumber());
        customer.setVille(initierPaymentMerchantRequestDTO.getVille());
        customer.setPays(initierPaymentMerchantRequestDTO.getPays());
        order.setCustomer(customer);
        order.setMerchant(merchant);
        order.setOrderStatus(OrderStatus.ENATTENTE);
        order.setAmount(initierPaymentMerchantRequestDTO.getAmount());
        order.setOrderDetails(initierPaymentMerchantRequestDTO.getOrderDetails());
        order.setCreationDate(new Date());
        order.setMerchantOrderID(initierPaymentMerchantRequestDTO.getOrderID());
        order.setReference(CommonUtils.generateReference());

        return order;
    }

    public static OrderWalletResponseDTO toOrderWalletResponseDTO(OrderDTO orderDTO){
        OrderWalletResponseDTO orderWalletResponseDTO = new OrderWalletResponseDTO();
        orderWalletResponseDTO.setAmount(orderDTO.getAmount());
        orderWalletResponseDTO.setMerchantName(orderDTO.getMerchant().getName());
        orderWalletResponseDTO.setMerchantNumber(orderDTO.getMerchant().getMobileNumber());
        orderWalletResponseDTO.setOrderStatus(orderDTO.getOrderStatus());
        orderWalletResponseDTO.setOrderDetails(orderDTO.getOrderDetails());
        return orderWalletResponseDTO;
    }

    public static ConfirmPaymentMerchantRequestDTO toConfirmPaymentMerchantRequestDTO(OrderDTO orderDTO, Date dateStatus, OrderStatus orderStatus){
        ConfirmPaymentMerchantRequestDTO confirmPaymentMerchantRequestDTO = new ConfirmPaymentMerchantRequestDTO();
        confirmPaymentMerchantRequestDTO.setAmount(orderDTO.getAmount());
        confirmPaymentMerchantRequestDTO.setCode("01");
        confirmPaymentMerchantRequestDTO.setMessage("success");
        confirmPaymentMerchantRequestDTO.setMerchantUserName(orderDTO.getMerchant().getUserName());
        confirmPaymentMerchantRequestDTO.setOrderID(orderDTO.getMerchantOrderID());
        confirmPaymentMerchantRequestDTO.setPaybyVersion("PayByVesrion");
        confirmPaymentMerchantRequestDTO.setReference(orderDTO.getReference());
        confirmPaymentMerchantRequestDTO.setTransactionDate(dateStatus);
        confirmPaymentMerchantRequestDTO.setStatus(orderStatus);
        return confirmPaymentMerchantRequestDTO;
    }


}
