package ma.payby.common.service.mapper;


import ma.payby.common.dto.PaiementDTO;
import ma.payby.common.jpa.model.Paiement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = PaiementMapper.class)
public class PaiementMapperUTest {
    PaiementDTO paiementDTO;
    Paiement paiement;

    @BeforeEach
    public void setUp(){
        paiement = InitiateObjects.initiatePaiement();
        paiementDTO = InitiateObjects.initiatePaiementDTO();
    }

    @Test
    public void toPaiement (){
        PaiementDTO paiementDTO = PaiementMapper.toPaiementDTO(paiement);
        Assertions.assertEquals(paiement.getOrder().getAmount(),paiementDTO.getOrder().getAmount());
        Assertions.assertEquals(paiement.getOrder().getCreationDate(),paiementDTO.getOrder().getCreationDate());
        Assertions.assertEquals(paiement.getOrder().getCustomer().getCustmerID(),paiementDTO.getOrder().getCustomer().getCustmerID());
        Assertions.assertEquals(paiement.getOrder().getCustomer().getAddress(),paiementDTO.getOrder().getCustomer().getAddress());
        Assertions.assertEquals(paiement.getOrder().getCustomer().getCodePostal(),paiementDTO.getOrder().getCustomer().getCodePostal());
        Assertions.assertEquals(paiement.getOrder().getCustomer().getEmail(),paiementDTO.getOrder().getCustomer().getEmail());
        Assertions.assertEquals(paiement.getOrder().getCustomer().getFirstName(),paiementDTO.getOrder().getCustomer().getFirstName());
        Assertions.assertEquals(paiement.getOrder().getCustomer().getLastName(),paiementDTO.getOrder().getCustomer().getLastName());
        Assertions.assertEquals(paiement.getOrder().getCustomer().getPays(),paiementDTO.getOrder().getCustomer().getPays());
        Assertions.assertEquals(paiement.getOrder().getCustomer().getPhoneNumber(),paiementDTO.getOrder().getCustomer().getPhoneNumber());
        Assertions.assertEquals(paiement.getOrder().getCustomer().getVille(),paiementDTO.getOrder().getCustomer().getVille());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getMobileNumber(),paiementDTO.getOrder().getMerchant().getMobileNumber());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getName(),paiementDTO.getOrder().getMerchant().getName());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getUserName(),paiementDTO.getOrder().getMerchant().getUserName());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getWallet().getWalletStatus(),paiementDTO.getOrder().getMerchant().getWallet().getWalletStatus());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getWallet().getLogo(),paiementDTO.getOrder().getMerchant().getWallet().getLogo());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getWallet().getPrivateKey(),paiementDTO.getOrder().getMerchant().getWallet().getPrivateKey());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getWallet().getSecretKey(),paiementDTO.getOrder().getMerchant().getWallet().getSecretKey());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getWallet().getPublicKey(),paiementDTO.getOrder().getMerchant().getWallet().getPublicKey());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getWallet().getWalletDescription(),paiementDTO.getOrder().getMerchant().getWallet().getWalletDescription());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getWallet().getWalletID(),paiementDTO.getOrder().getMerchant().getWallet().getWalletID());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getWallet().getWalletName(),paiementDTO.getOrder().getMerchant().getWallet().getWalletName());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getWallet().getWalletOwner(),paiementDTO.getOrder().getMerchant().getWallet().getWalletOwner());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getWallet().getApiKey(),paiementDTO.getOrder().getMerchant().getWallet().getApiKey());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getDescription(),paiementDTO.getOrder().getMerchant().getDescription());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getEmail(),paiementDTO.getOrder().getMerchant().getEmail());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getLogo(),paiementDTO.getOrder().getMerchant().getLogo());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getMerchantID(),paiementDTO.getOrder().getMerchant().getMerchantID());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getMerchantResponseURL(),paiementDTO.getOrder().getMerchant().getMerchantResponseURL());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getMerchantStatus(),paiementDTO.getOrder().getMerchant().getMerchantStatus());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getPaybyRedirectionURL(),paiementDTO.getOrder().getMerchant().getPaybyRedirectionURL());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getPaybyVersion(),paiementDTO.getOrder().getMerchant().getPaybyVersion());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getPrivateKey(),paiementDTO.getOrder().getMerchant().getPrivateKey());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getPublicKey(),paiementDTO.getOrder().getMerchant().getPublicKey());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getSecretKey(),paiementDTO.getOrder().getMerchant().getSecretKey());
        Assertions.assertEquals(paiement.getOrder().getMerchant().getUrlWebsite(),paiementDTO.getOrder().getMerchant().getUrlWebsite());
        Assertions.assertEquals(paiement.getOrder().getOrderDetails(),paiementDTO.getOrder().getOrderDetails());
        Assertions.assertEquals(paiement.getOrder().getMerchantOrderID(),paiementDTO.getOrder().getMerchantOrderID());
        Assertions.assertEquals(paiement.getOrder().getOrderID(),paiementDTO.getOrder().getOrderID());
        Assertions.assertEquals(paiement.getOrder().getReference(),paiementDTO.getOrder().getReference());
        Assertions.assertEquals(paiement.getOrder().getOrderStatus(),paiementDTO.getOrder().getOrderStatus());
        Assertions.assertEquals(paiement.getWallet().getWalletStatus(),paiementDTO.getWallet().getWalletStatus());
        Assertions.assertEquals(paiement.getWallet().getLogo(),paiementDTO.getWallet().getLogo());
        Assertions.assertEquals(paiement.getWallet().getPrivateKey(),paiementDTO.getWallet().getPrivateKey());
        Assertions.assertEquals(paiement.getWallet().getSecretKey(),paiementDTO.getWallet().getSecretKey());
        Assertions.assertEquals(paiement.getWallet().getPublicKey(),paiementDTO.getWallet().getPublicKey());
        Assertions.assertEquals(paiement.getWallet().getWalletDescription(),paiementDTO.getWallet().getWalletDescription());
        Assertions.assertEquals(paiement.getWallet().getWalletID(),paiementDTO.getWallet().getWalletID());
        Assertions.assertEquals(paiement.getWallet().getWalletName(),paiementDTO.getWallet().getWalletName());
        Assertions.assertEquals(paiement.getWallet().getWalletOwner(),paiementDTO.getWallet().getWalletOwner());
        Assertions.assertEquals(paiement.getWallet().getApiKey(),paiementDTO.getWallet().getApiKey());
        Assertions.assertEquals(paiement.getPaiementID(),paiementDTO.getPaiementID());

    }
    @Test
    public void toPaiementDTO(){
        Paiement paiement = PaiementMapper.toPaiement(paiementDTO);
        Assertions.assertEquals(paiementDTO.getDateStatus(),paiement.getDateStatus());
        Assertions.assertEquals(paiementDTO.getOrder().getAmount(),paiement.getOrder().getAmount());
        Assertions.assertEquals(paiementDTO.getOrder().getCreationDate(),paiement.getOrder().getCreationDate());
        Assertions.assertEquals(paiementDTO.getOrder().getCustomer().getCustmerID(),paiement.getOrder().getCustomer().getCustmerID());
        Assertions.assertEquals(paiementDTO.getOrder().getCustomer().getAddress(),paiement.getOrder().getCustomer().getAddress());
        Assertions.assertEquals(paiementDTO.getOrder().getCustomer().getCodePostal(),paiement.getOrder().getCustomer().getCodePostal());
        Assertions.assertEquals(paiementDTO.getOrder().getCustomer().getEmail(),paiement.getOrder().getCustomer().getEmail());
        Assertions.assertEquals(paiementDTO.getOrder().getCustomer().getFirstName(),paiement.getOrder().getCustomer().getFirstName());
        Assertions.assertEquals(paiementDTO.getOrder().getCustomer().getLastName(),paiement.getOrder().getCustomer().getLastName());
        Assertions.assertEquals(paiementDTO.getOrder().getCustomer().getPays(),paiement.getOrder().getCustomer().getPays());
        Assertions.assertEquals(paiementDTO.getOrder().getCustomer().getPhoneNumber(),paiement.getOrder().getCustomer().getPhoneNumber());
        Assertions.assertEquals(paiementDTO.getOrder().getCustomer().getVille(),paiement.getOrder().getCustomer().getVille());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getMobileNumber(),paiement.getOrder().getMerchant().getMobileNumber());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getName(),paiement.getOrder().getMerchant().getName());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getUserName(),paiement.getOrder().getMerchant().getUserName());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getWallet().getWalletStatus(),paiement.getOrder().getMerchant().getWallet().getWalletStatus());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getWallet().getLogo(),paiement.getOrder().getMerchant().getWallet().getLogo());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getWallet().getPrivateKey(),paiement.getOrder().getMerchant().getWallet().getPrivateKey());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getWallet().getSecretKey(),paiement.getOrder().getMerchant().getWallet().getSecretKey());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getWallet().getPublicKey(),paiement.getOrder().getMerchant().getWallet().getPublicKey());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getWallet().getWalletDescription(),paiement.getOrder().getMerchant().getWallet().getWalletDescription());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getWallet().getWalletID(),paiement.getOrder().getMerchant().getWallet().getWalletID());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getWallet().getWalletName(),paiement.getOrder().getMerchant().getWallet().getWalletName());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getWallet().getWalletOwner(),paiement.getOrder().getMerchant().getWallet().getWalletOwner());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getWallet().getApiKey(),paiement.getOrder().getMerchant().getWallet().getApiKey());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getDescription(),paiement.getOrder().getMerchant().getDescription());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getEmail(),paiement.getOrder().getMerchant().getEmail());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getLogo(),paiement.getOrder().getMerchant().getLogo());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getMerchantID(),paiement.getOrder().getMerchant().getMerchantID());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getMerchantResponseURL(),paiement.getOrder().getMerchant().getMerchantResponseURL());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getMerchantStatus(),paiement.getOrder().getMerchant().getMerchantStatus());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getPaybyRedirectionURL(),paiement.getOrder().getMerchant().getPaybyRedirectionURL());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getPaybyVersion(),paiement.getOrder().getMerchant().getPaybyVersion());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getPrivateKey(),paiement.getOrder().getMerchant().getPrivateKey());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getPublicKey(),paiement.getOrder().getMerchant().getPublicKey());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getSecretKey(),paiement.getOrder().getMerchant().getSecretKey());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchant().getUrlWebsite(),paiement.getOrder().getMerchant().getUrlWebsite());
        Assertions.assertEquals(paiementDTO.getOrder().getOrderDetails(),paiement.getOrder().getOrderDetails());
        Assertions.assertEquals(paiementDTO.getOrder().getMerchantOrderID(),paiement.getOrder().getMerchantOrderID());
        Assertions.assertEquals(paiementDTO.getOrder().getOrderID(),paiement.getOrder().getOrderID());
        Assertions.assertEquals(paiementDTO.getOrder().getReference(),paiement.getOrder().getReference());
        Assertions.assertEquals(paiementDTO.getOrder().getOrderStatus(),paiement.getOrder().getOrderStatus());
        Assertions.assertEquals(paiementDTO.getWallet().getWalletStatus(),paiement.getWallet().getWalletStatus());
        Assertions.assertEquals(paiementDTO.getWallet().getLogo(),paiement.getWallet().getLogo());
        Assertions.assertEquals(paiementDTO.getWallet().getPrivateKey(),paiement.getWallet().getPrivateKey());
        Assertions.assertEquals(paiementDTO.getWallet().getSecretKey(),paiement.getWallet().getSecretKey());
        Assertions.assertEquals(paiementDTO.getWallet().getPublicKey(),paiement.getWallet().getPublicKey());
        Assertions.assertEquals(paiementDTO.getWallet().getWalletDescription(),paiement.getWallet().getWalletDescription());
        Assertions.assertEquals(paiementDTO.getWallet().getWalletID(),paiement.getWallet().getWalletID());
        Assertions.assertEquals(paiementDTO.getWallet().getWalletName(),paiement.getWallet().getWalletName());
        Assertions.assertEquals(paiementDTO.getWallet().getWalletOwner(),paiement.getWallet().getWalletOwner());
        Assertions.assertEquals(paiementDTO.getWallet().getApiKey(),paiement.getWallet().getApiKey());
        Assertions.assertEquals(paiementDTO.getPaiementID(),paiement.getPaiementID());


    }
}
