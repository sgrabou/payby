package ma.payby.common.service.mapper;

import ma.payby.common.dto.WalletDTO;
import ma.payby.common.enums.WalletStatus;
import ma.payby.common.jpa.model.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;



@SpringBootTest(classes= WalletMapper.class)
class WalletMapperUTest {
    Wallet wallet;
    WalletDTO walletDTO;

    @BeforeEach
    public void setUp() {
        wallet = InitiateObjects.initiateWallet();
        walletDTO = InitiateObjects.initiateWalletDTO();
    }

    @Test
   public void walletToWalletDTOTest() {
        WalletDTO walletDTO = WalletMapper.toWalletDTO(wallet);
        Assertions.assertEquals(walletDTO.getPrivateKey(), wallet.getPrivateKey());
        Assertions.assertEquals(walletDTO.getLogo(), wallet.getLogo());
        Assertions.assertEquals(walletDTO.getPublicKey(), wallet.getPublicKey());
        Assertions.assertEquals(walletDTO.getSecretKey(), wallet.getSecretKey());
        Assertions.assertEquals(walletDTO.getWalletDescription(), wallet.getWalletDescription());
        Assertions.assertEquals(walletDTO.getWalletID(), wallet.getWalletID());
        Assertions.assertEquals(walletDTO.getWalletName(), wallet.getWalletName());
        Assertions.assertEquals(walletDTO.getWalletOwner(), wallet.getWalletOwner());
        Assertions.assertEquals(walletDTO.getWalletStatus(),wallet.getWalletStatus());

    }

    @Test
    public void walletDTOtoWalletTest() {
        Wallet wallet = WalletMapper.toWallet(walletDTO);
        Assertions.assertEquals(walletDTO.getPrivateKey(), wallet.getPrivateKey());
        Assertions.assertEquals(walletDTO.getLogo(), wallet.getLogo());
        Assertions.assertEquals(walletDTO.getPublicKey(), wallet.getPublicKey());
        Assertions.assertEquals(walletDTO.getSecretKey(), wallet.getSecretKey());
        Assertions.assertEquals(walletDTO.getWalletDescription(), wallet.getWalletDescription());
        Assertions.assertEquals(walletDTO.getWalletID(), wallet.getWalletID());
        Assertions.assertEquals(walletDTO.getWalletName(), wallet.getWalletName());
        Assertions.assertEquals(walletDTO.getWalletOwner(), wallet.getWalletOwner());
        Assertions.assertEquals(walletDTO.getWalletStatus(),wallet.getWalletStatus());
    }
}