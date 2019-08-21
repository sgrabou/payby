package ma.payby.services.admin.service;

import ma.payby.common.dto.MerchantDTO;
import ma.payby.common.jpa.model.Merchant;
import ma.payby.common.jpa.repository.MerchantRepository;
import ma.payby.common.service.mapper.MerchantMapper;
import ma.payby.common.utils.CommonUtils;
import ma.payby.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdminMerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    public MerchantDTO getMerchantByName(String name) throws BusinessException {
        Merchant merchant = merchantRepository.findByName(name);
        if(merchant == null)
            throw new BusinessException("M00001", CommonUtils.ERROR_BUSINESS.get("M00001"));

        return MerchantMapper.toMerchantDTO(merchant);
    }

    public List<MerchantDTO> getAllMerchant() throws BusinessException {
        List<Merchant> merchants = merchantRepository.findAll();
        List<MerchantDTO> merchantDTOList = merchants.stream()
                .map(e -> MerchantMapper.toMerchantDTO(e)).collect(Collectors.toList());
        return merchantDTOList;
    }

    public MerchantDTO addMerchant(MerchantDTO merchantDTO){
        Merchant savedMerchant = merchantRepository.save(MerchantMapper.toMerchant(merchantDTO));
        return MerchantMapper.toMerchantDTO(savedMerchant);
    }

    public MerchantDTO editMerchant(MerchantDTO merchantDTO) throws BusinessException{
        Merchant merchant = merchantRepository.findByName(merchantDTO.getName());
        if(merchant ==null)
            throw new BusinessException("M00001", CommonUtils.ERROR_BUSINESS.get("M00001"));
        Merchant savedMerchant = merchantRepository.save(MerchantMapper.toMerchant(merchantDTO));
        return MerchantMapper.toMerchantDTO(savedMerchant);
    }
}
