package ma.payby.common.service.mapper;

import ma.payby.common.dto.WalletDTO;
import ma.payby.common.dto.MerchantDTO;
import ma.payby.common.jpa.model.Merchant;
import ma.payby.common.jpa.model.Wallet;
import org.springframework.beans.BeanUtils;

public class MerchantMapper {
    public static MerchantDTO toMerchantDTO(Merchant merchant){
        WalletDTO walletDTO = new WalletDTO();
        BeanUtils.copyProperties(merchant.getWallet(),walletDTO);
        MerchantDTO merchantDTO = new MerchantDTO();
        BeanUtils.copyProperties(merchant, merchantDTO);
        merchantDTO.setWallet(walletDTO);
        return merchantDTO;
    }

    public static Merchant toMerchant(MerchantDTO merchantDTO){
        Wallet wallet = new Wallet();
        BeanUtils.copyProperties(merchantDTO.getWallet(),wallet);
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(merchantDTO, merchant);
        merchant.setWallet(wallet);
        return merchant;
    }
}
