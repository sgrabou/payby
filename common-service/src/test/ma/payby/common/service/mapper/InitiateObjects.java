package ma.payby.common.service.mapper;

import ma.payby.common.dto.*;
import ma.payby.common.enums.MerchantStatus;
import ma.payby.common.enums.OrderStatus;
import ma.payby.common.enums.WalletStatus;
import ma.payby.common.jpa.model.*;

import java.math.BigDecimal;
import java.util.Date;

public class InitiateObjects {

    public static Customer initiateCustomer(){
        Customer customer = new Customer();
        customer.setAddress("Rue du wallet");
        customer.setCodePostal("2020");
        customer.setEmail("france@gmail.com");
        customer.setFirstName("Sam");
        customer.setLastName("Samy");
        customer.setPays("Canada");
        customer.setPhoneNumber("0649999999");
        customer.setVille("Tokyo");
        customer.setCustmerID(new Long(5));
        return customer;
    }

    public static Wallet initiateWallet() {
        Wallet wallet = new Wallet();
        wallet.setWalletStatus(WalletStatus.ACTIVE);
        wallet.setWalletOwner("Kamina");
        wallet.setWalletName("Simon");
        wallet.setWalletID(new Long(5));
        wallet.setWalletDescription("here");
        wallet.setSecretKey("123abc");
        wallet.setPublicKey("123ABC");
        wallet.setPrivateKey("321ABC");
        wallet.setLogo("/directory/wallet/logo.pnj");
        wallet.setApiKey("abc123");
        return wallet;
    }

public static Merchant initiateMerchant(Wallet wallet){
    Merchant merchant = new Merchant();
    merchant.setWallet(wallet);
    merchant.setDescription("this is a merchant");
    merchant.setEmail("merchant@gmail.com");
    merchant.setLogo("/directory/merchant/logo.pnj");
    merchant.setMerchantID(new Long(43242));
    merchant.setMerchantResponseURL("/potato.com");
    merchant.setMerchantStatus(MerchantStatus.ACTIVE);
    merchant.setMobileNumber("0645873908");
    merchant.setName("Samy");
    merchant.setPaybyRedirectionURL("/redirection.com");
    merchant.setPaybyVersion("2.0");
    merchant.setPrivateKey("1234abc");
    merchant.setSecretKey("123ABC");
    merchant.setUrlWebsite("www.merchant.com");
    merchant.setUserName("Bestboy");
    merchant.setPublicKey("ABC1234");
    return merchant;
}

    public static MerchantDTO initiateMerchantDTO(WalletDTO walletDTO) {
        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setWallet(walletDTO);
        merchantDTO.setDescription("this is a merchantDTO");
        merchantDTO.setEmail("merchantDTO@gmail.com");
        merchantDTO.setLogo("/directory/merchantDTO/logo.pnj");
        merchantDTO.setMerchantID(new Long(43242));
        merchantDTO.setMerchantResponseURL("/potato.com");
        merchantDTO.setMerchantStatus(MerchantStatus.ACTIVE);
        merchantDTO.setMobileNumber("0645873908");
        merchantDTO.setName("Samy");
        merchantDTO.setPaybyRedirectionURL("/redirection.com");
        merchantDTO.setPaybyVersion("2.0");
        merchantDTO.setPrivateKey("1234abc");
        merchantDTO.setSecretKey("123ABC");
        merchantDTO.setUrlWebsite("www.merchantDTO.com");
        merchantDTO.setUserName("Bestboy");
        merchantDTO.setPublicKey("ABC1234");
        return merchantDTO;
    }

    public static WalletDTO initiateWalletDTO() {
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setWalletStatus(WalletStatus.ACTIVE);
        walletDTO.setWalletOwner("Kamina");
        walletDTO.setWalletName("Simon");
        walletDTO.setWalletID(new Long(5));
        walletDTO.setWalletDescription("here");
        walletDTO.setSecretKey("123abc");
        walletDTO.setPublicKey("123ABC");
        walletDTO.setPrivateKey("321ABC");
        walletDTO.setLogo("/directory/walletDTO/logo.pnj");
        walletDTO.setApiKey("abc123");
        return walletDTO;
    }

    public static CustomerDTO initiateCustomerDTO() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setAddress("Rue de wallet");
        customerDTO.setCodePostal("2020");
        customerDTO.setEmail("france@gmail.com");
        customerDTO.setFirstName("Sam");
        customerDTO.setLastName("Samy");
        customerDTO.setPays("Canada");
        customerDTO.setPhoneNumber("0649999999");
        customerDTO.setVille("Tokyo");
        customerDTO.setCustmerID(new Long(5));
        return customerDTO;
    }


    public static OrderDTO initiateOrderDTO() {
        OrderDTO orderDTO = new OrderDTO();
        CustomerDTO customerDTO = initiateCustomerDTO();
        orderDTO.setCustomer(customerDTO);
        WalletDTO walletDTO = initiateWalletDTO();
        MerchantDTO merchantDTO = initiateMerchantDTO(walletDTO);
        orderDTO.setMerchant(merchantDTO);
        orderDTO.setAmount(BigDecimal.valueOf(4));
        orderDTO.setCreationDate(new Date());
        orderDTO.setMerchantOrderID("30");
        orderDTO.setOrderDetails("done");
        orderDTO.setOrderStatus(OrderStatus.CAPTURED);
        orderDTO.setReference("hhh");
        orderDTO.setOrderID(new Long(5));
        return orderDTO;
    }

    public static Order initiateOrder() {
        Order order = new Order();
        Customer customer = InitiateObjects.initiateCustomer();
        order.setCustomer(customer);
        Wallet wallet = InitiateObjects.initiateWallet();
        Merchant merchant = InitiateObjects.initiateMerchant(wallet);
        merchant.setWallet(wallet);
        order.setMerchant(merchant);
        order.setAmount(BigDecimal.valueOf(4));
        order.setCreationDate(new Date());
        order.setMerchantOrderID("30");
        order.setOrderDetails("done");
        order.setOrderStatus(OrderStatus.CAPTURED);
        order.setReference("hhh");
        order.setOrderID(new Long(5));
        return order;
    }

    public static Paiement initiatePaiement() {
        Paiement paiement = new Paiement();
        paiement.setDateStatus(new Date());
        Wallet wallet = initiateWallet();
        paiement.setWallet(wallet);
        paiement.setPaiementID(new Long(5));
        Order order =initiateOrder();
        paiement.setOrder(order);
        paiement.setOrderStatus(OrderStatus.CAPTURED);
        return paiement;
    }

    public static PaiementDTO initiatePaiementDTO() {
        PaiementDTO paiementDTO = new PaiementDTO();
        paiementDTO.setDateStatus(new Date());
        paiementDTO.setOrderStatus(OrderStatus.CAPTURED);
        paiementDTO.setPaiementID(new Long(5));
        WalletDTO walletDTO = initiateWalletDTO();
        paiementDTO.setWallet(walletDTO);
        OrderDTO orderDTO = initiateOrderDTO();
        paiementDTO.setOrder(orderDTO);
        return paiementDTO;
    }

}
