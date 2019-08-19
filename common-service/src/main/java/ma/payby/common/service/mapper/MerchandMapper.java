package ma.payby.common.service.mapper;

import ma.payby.common.dto.WalletDTO;
import ma.payby.common.dto.MerchandDTO;
import ma.payby.common.jpa.model.Merchand;
import ma.payby.common.jpa.model.Wallet;
import org.springframework.beans.BeanUtils;

public class MerchandMapper {
    public static MerchandDTO toMerchandDTO(Merchand merchand){
        WalletDTO walletDTO = new WalletDTO();
        BeanUtils.copyProperties(merchand.getWallet(),walletDTO);
        MerchandDTO merchandDTO = new MerchandDTO();
        BeanUtils.copyProperties(merchand, merchandDTO);
        merchandDTO.setWallet(walletDTO);
        return merchandDTO;
    }

    public static Merchand toMerchand(MerchandDTO merchandDTO){
        Wallet wallet = new Wallet();
        BeanUtils.copyProperties(merchandDTO.getWallet(),wallet);
        Merchand merchand = new Merchand();
        BeanUtils.copyProperties(merchandDTO, merchand);
        merchand.setWallet(wallet);
        return merchand;
    }
}
