package ma.payby.common.service.mapper;


import ma.payby.common.dto.OrderDTO;
import ma.payby.common.jpa.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest(classes = OrderMapper.class)
public class OrderMapperUTest {
    private Order order;
    private OrderDTO orderDTO;

    @BeforeEach
    public void setUP() {
        order = InitiateObjects.initiateOrder();
        orderDTO = InitiateObjects.initiateOrderDTO();
    }

    @Test
    public void ordertoOrderDTO() {
        OrderDTO orderDTO = OrderMapper.toOrderDTO(order);
        Assertions.assertEquals(order.getCustomer().getCustmerID(),orderDTO.getCustomer().getCustmerID());
        Assertions.assertEquals(order.getCustomer().getAddress(),orderDTO.getCustomer().getAddress());
        Assertions.assertEquals(order.getCustomer().getCodePostal(),orderDTO.getCustomer().getCodePostal());
        Assertions.assertEquals(order.getCustomer().getEmail(),orderDTO.getCustomer().getEmail());
        Assertions.assertEquals(order.getCustomer().getFirstName(),orderDTO.getCustomer().getFirstName());
        Assertions.assertEquals(order.getCustomer().getLastName(),orderDTO.getCustomer().getLastName());
        Assertions.assertEquals(order.getCustomer().getPays(),orderDTO.getCustomer().getPays());
        Assertions.assertEquals(order.getCustomer().getPhoneNumber(),orderDTO.getCustomer().getPhoneNumber());
        Assertions.assertEquals(order.getCustomer().getVille(),orderDTO.getCustomer().getVille());
        Assertions.assertEquals(order.getMerchant().getMobileNumber(),orderDTO.getMerchant().getMobileNumber());
        Assertions.assertEquals(order.getMerchant().getName(),orderDTO.getMerchant().getName());
        Assertions.assertEquals(order.getMerchant().getUserName(),orderDTO.getMerchant().getUserName());
        Assertions.assertEquals(order.getMerchant().getWallet().getWalletStatus(),orderDTO.getMerchant().getWallet().getWalletStatus());
        Assertions.assertEquals(order.getMerchant().getWallet().getLogo(),orderDTO.getMerchant().getWallet().getLogo());
        Assertions.assertEquals(order.getMerchant().getWallet().getPrivateKey(),orderDTO.getMerchant().getWallet().getPrivateKey());
        Assertions.assertEquals(order.getMerchant().getWallet().getSecretKey(),orderDTO.getMerchant().getWallet().getSecretKey());
        Assertions.assertEquals(order.getMerchant().getWallet().getPublicKey(),orderDTO.getMerchant().getWallet().getPublicKey());
        Assertions.assertEquals(order.getMerchant().getWallet().getWalletDescription(),orderDTO.getMerchant().getWallet().getWalletDescription());
        Assertions.assertEquals(order.getMerchant().getWallet().getWalletID(),orderDTO.getMerchant().getWallet().getWalletID());
        Assertions.assertEquals(order.getMerchant().getWallet().getWalletName(),orderDTO.getMerchant().getWallet().getWalletName());
        Assertions.assertEquals(order.getMerchant().getWallet().getWalletOwner(),orderDTO.getMerchant().getWallet().getWalletOwner());
        Assertions.assertEquals(order.getMerchant().getWallet().getApiKey(),orderDTO.getMerchant().getWallet().getApiKey());
        Assertions.assertEquals(order.getMerchant().getDescription(),orderDTO.getMerchant().getDescription());
        Assertions.assertEquals(order.getMerchant().getEmail(),orderDTO.getMerchant().getEmail());
        Assertions.assertEquals(order.getMerchant().getLogo(),orderDTO.getMerchant().getLogo());
        Assertions.assertEquals(order.getMerchant().getMerchantID(),orderDTO.getMerchant().getMerchantID());
        Assertions.assertEquals(order.getMerchant().getMerchantResponseURL(),orderDTO.getMerchant().getMerchantResponseURL());
        Assertions.assertEquals(order.getMerchant().getMerchantStatus(),orderDTO.getMerchant().getMerchantStatus());
        Assertions.assertEquals(order.getMerchant().getPaybyRedirectionURL(),orderDTO.getMerchant().getPaybyRedirectionURL());
        Assertions.assertEquals(order.getMerchant().getPaybyVersion(),orderDTO.getMerchant().getPaybyVersion());
        Assertions.assertEquals(order.getMerchant().getPrivateKey(),orderDTO.getMerchant().getPrivateKey());
        Assertions.assertEquals(order.getMerchant().getPublicKey(),orderDTO.getMerchant().getPublicKey());
        Assertions.assertEquals(order.getMerchant().getSecretKey(),orderDTO.getMerchant().getSecretKey());
        Assertions.assertEquals(order.getMerchant().getUrlWebsite(),orderDTO.getMerchant().getUrlWebsite());
        Assertions.assertEquals(order.getAmount(),orderDTO.getAmount());
        Assertions.assertEquals(order.getCreationDate(),orderDTO.getCreationDate());
        Assertions.assertEquals(order.getMerchantOrderID(),orderDTO.getMerchantOrderID());
        Assertions.assertEquals(order.getOrderDetails(),orderDTO.getOrderDetails());
        Assertions.assertEquals(order.getReference(),orderDTO.getReference());
        Assertions.assertEquals(order.getOrderID(),orderDTO.getOrderID());
    }

    @Test
    public void OrderDTOtoOrderTest(){
        Order order = OrderMapper.toOrder(orderDTO);
        Assertions.assertEquals(orderDTO.getCustomer().getCustmerID(),order.getCustomer().getCustmerID());
        Assertions.assertEquals(orderDTO.getCustomer().getAddress(),order.getCustomer().getAddress());
        Assertions.assertEquals(orderDTO.getCustomer().getCodePostal(),order.getCustomer().getCodePostal());
        Assertions.assertEquals(orderDTO.getCustomer().getEmail(),order.getCustomer().getEmail());
        Assertions.assertEquals(orderDTO.getCustomer().getFirstName(),order.getCustomer().getFirstName());
        Assertions.assertEquals(orderDTO.getCustomer().getLastName(),order.getCustomer().getLastName());
        Assertions.assertEquals(orderDTO.getCustomer().getPays(),order.getCustomer().getPays());
        Assertions.assertEquals(orderDTO.getCustomer().getPhoneNumber(),order.getCustomer().getPhoneNumber());
        Assertions.assertEquals(orderDTO.getCustomer().getVille(),order.getCustomer().getVille());
        Assertions.assertEquals(orderDTO.getMerchant().getMobileNumber(),order.getMerchant().getMobileNumber());
        Assertions.assertEquals(orderDTO.getMerchant().getName(),order.getMerchant().getName());
        Assertions.assertEquals(orderDTO.getMerchant().getUserName(),order.getMerchant().getUserName());
        Assertions.assertEquals(orderDTO.getMerchant().getWallet().getWalletStatus(),order.getMerchant().getWallet().getWalletStatus());
        Assertions.assertEquals(orderDTO.getMerchant().getWallet().getLogo(),order.getMerchant().getWallet().getLogo());
        Assertions.assertEquals(orderDTO.getMerchant().getWallet().getPrivateKey(),order.getMerchant().getWallet().getPrivateKey());
        Assertions.assertEquals(orderDTO.getMerchant().getWallet().getSecretKey(),order.getMerchant().getWallet().getSecretKey());
        Assertions.assertEquals(orderDTO.getMerchant().getWallet().getPublicKey(),order.getMerchant().getWallet().getPublicKey());
        Assertions.assertEquals(orderDTO.getMerchant().getWallet().getWalletDescription(),order.getMerchant().getWallet().getWalletDescription());
        Assertions.assertEquals(orderDTO.getMerchant().getWallet().getWalletID(),order.getMerchant().getWallet().getWalletID());
        Assertions.assertEquals(orderDTO.getMerchant().getWallet().getWalletName(),order.getMerchant().getWallet().getWalletName());
        Assertions.assertEquals(orderDTO.getMerchant().getWallet().getWalletOwner(),order.getMerchant().getWallet().getWalletOwner());
        Assertions.assertEquals(orderDTO.getMerchant().getWallet().getApiKey(),order.getMerchant().getWallet().getApiKey());
        Assertions.assertEquals(orderDTO.getMerchant().getDescription(),order.getMerchant().getDescription());
        Assertions.assertEquals(orderDTO.getMerchant().getEmail(),order.getMerchant().getEmail());
        Assertions.assertEquals(orderDTO.getMerchant().getLogo(),order.getMerchant().getLogo());
        Assertions.assertEquals(orderDTO.getMerchant().getMerchantID(),order.getMerchant().getMerchantID());
        Assertions.assertEquals(orderDTO.getMerchant().getMerchantResponseURL(),order.getMerchant().getMerchantResponseURL());
        Assertions.assertEquals(orderDTO.getMerchant().getMerchantStatus(),order.getMerchant().getMerchantStatus());
        Assertions.assertEquals(orderDTO.getMerchant().getPaybyRedirectionURL(),order.getMerchant().getPaybyRedirectionURL());
        Assertions.assertEquals(orderDTO.getMerchant().getPaybyVersion(),order.getMerchant().getPaybyVersion());
        Assertions.assertEquals(orderDTO.getMerchant().getPrivateKey(),order.getMerchant().getPrivateKey());
        Assertions.assertEquals(orderDTO.getMerchant().getPublicKey(),order.getMerchant().getPublicKey());
        Assertions.assertEquals(orderDTO.getMerchant().getSecretKey(),order.getMerchant().getSecretKey());
        Assertions.assertEquals(orderDTO.getMerchant().getUrlWebsite(),order.getMerchant().getUrlWebsite());
        Assertions.assertEquals(orderDTO.getAmount(),order.getAmount());
        Assertions.assertEquals(orderDTO.getCreationDate(),order.getCreationDate());
        Assertions.assertEquals(orderDTO.getMerchantOrderID(),order.getMerchantOrderID());
        Assertions.assertEquals(orderDTO.getOrderDetails(),order.getOrderDetails());
        Assertions.assertEquals(orderDTO.getReference(),order.getReference());
        Assertions.assertEquals(orderDTO.getOrderID(),order.getOrderID());
    }
}
