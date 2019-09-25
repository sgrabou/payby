package ma.payby.common.service.mapper;

import ma.payby.common.dto.MerchantDTO;
import ma.payby.common.jpa.model.Merchant;
import ma.payby.common.jpa.model.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MerchantMapper.class)
public class MerchantMapperUTest {
    Merchant merchant;
    MerchantDTO merchantDTO;

    @BeforeEach
    public void setUp(){
        merchant = InitiateObjects.initiateMerchant(InitiateObjects.initiateWallet());
        merchantDTO = InitiateObjects.initiateMerchantDTO(InitiateObjects.initiateWalletDTO());
    }

    @Test
    public void toMerchantDTO(){
        MerchantDTO merchantDTO = MerchantMapper.toMerchantDTO(merchant);
        Assertions.assertEquals(merchant.getWallet(),merchantDTO.getWallet());
        Assertions.assertEquals(merchant.getDescription(),merchantDTO.getDescription());
        Assertions.assertEquals(merchant.getEmail(),merchantDTO.getEmail());
        Assertions.assertEquals(merchant.getLogo(),merchantDTO.getLogo());
        Assertions.assertEquals(merchant.getMerchantID(),merchantDTO.getMerchantID());
        Assertions.assertEquals(merchant.getMerchantResponseURL(),merchantDTO.getMerchantResponseURL());
        Assertions.assertEquals(merchant.getMerchantStatus(),merchantDTO.getMerchantStatus());
        Assertions.assertEquals(merchant.getMobileNumber(),merchantDTO.getMobileNumber());
        Assertions.assertEquals(merchant.getName(),merchantDTO.getName());
        Assertions.assertEquals(merchant.getPaybyRedirectionURL(),merchantDTO.getPaybyRedirectionURL());
        Assertions.assertEquals(merchant.getPaybyVersion(),merchantDTO.getPaybyVersion());
        Assertions.assertEquals(merchant.getPrivateKey(),merchantDTO.getPrivateKey());
        Assertions.assertEquals(merchant.getPublicKey(),merchantDTO.getPublicKey());
        Assertions.assertEquals(merchant.getSecretKey(),merchantDTO.getSecretKey());
        Assertions.assertEquals(merchant.getUserName(),merchantDTO.getUserName());
        Assertions.assertEquals(merchant.getUrlWebsite(),merchantDTO.getUrlWebsite());
    }

    @Test
    public void toMerchant(){
        Merchant merchant = MerchantMapper.toMerchant(merchantDTO);
        Assertions.assertEquals(merchantDTO.getWallet(),merchant.getWallet());
        Assertions.assertEquals(merchantDTO.getDescription(),merchant.getDescription());
        Assertions.assertEquals(merchantDTO.getEmail(),merchant.getEmail());
        Assertions.assertEquals(merchantDTO.getLogo(),merchant.getLogo());
        Assertions.assertEquals(merchantDTO.getMerchantID(),merchant.getMerchantID());
        Assertions.assertEquals(merchantDTO.getMerchantResponseURL(),merchant.getMerchantResponseURL());
        Assertions.assertEquals(merchantDTO.getMerchantStatus(),merchant.getMerchantStatus());
        Assertions.assertEquals(merchantDTO.getMobileNumber(),merchant.getMobileNumber());
        Assertions.assertEquals(merchantDTO.getName(),merchant.getName());
        Assertions.assertEquals(merchantDTO.getPaybyRedirectionURL(),merchant.getPaybyRedirectionURL());
        Assertions.assertEquals(merchantDTO.getPaybyVersion(),merchant.getPaybyVersion());
        Assertions.assertEquals(merchantDTO.getPrivateKey(),merchant.getPrivateKey());
        Assertions.assertEquals(merchantDTO.getPublicKey(),merchant.getPublicKey());
        Assertions.assertEquals(merchantDTO.getSecretKey(),merchant.getSecretKey());
        Assertions.assertEquals(merchantDTO.getUserName(),merchant.getUserName());
        Assertions.assertEquals(merchantDTO.getUrlWebsite(),merchant.getUrlWebsite());
    }
}
