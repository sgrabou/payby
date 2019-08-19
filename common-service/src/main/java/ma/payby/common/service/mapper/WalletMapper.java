package ma.payby.common.service.mapper;

import ma.payby.common.dto.WalletDTO;
import ma.payby.common.jpa.model.Wallet;
import org.springframework.beans.BeanUtils;

public class WalletMapper {
    public static WalletDTO toWalletDTO(Wallet wallet){
        WalletDTO walletDTO = new WalletDTO();
        BeanUtils.copyProperties(wallet, walletDTO);
        return walletDTO;
    }

    public static Wallet toWallet(WalletDTO walletDTO){
        Wallet wallet = new Wallet();
        BeanUtils.copyProperties(walletDTO, wallet);
        return wallet;
    }
}
