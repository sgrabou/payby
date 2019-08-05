package ma.payby.services.admin.service;

import ma.payby.common.dto.MerchandDTO;
import ma.payby.common.jpa.model.Merchand;
import ma.payby.common.jpa.repository.MerchandRepository;
import ma.payby.common.service.mapper.MerchandMapper;
import ma.payby.common.utils.CommonUtils;
import ma.payby.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdminMerchandService {
    @Autowired
    private MerchandRepository merchandRepository;

    public MerchandDTO getMerchandByName(String name) throws BusinessException {
        Merchand merchand = merchandRepository.findByName(name);
        if(merchand == null)
            throw new BusinessException("M00001", CommonUtils.ERROR_BUSINESS.get("M00001"));

        return MerchandMapper.toMerchandDTO(merchand);
    }

    public List<MerchandDTO> getAllMerchand() throws BusinessException {
        List<Merchand> merchands = merchandRepository.findAll();
        List<MerchandDTO> merchandDTOList = merchands.stream()
                .map(e -> MerchandMapper.toMerchandDTO(e)).collect(Collectors.toList());
        return merchandDTOList;
    }

    public MerchandDTO addMerchand(MerchandDTO merchandDTO){
        Merchand savedMerchand = merchandRepository.save(MerchandMapper.toMerchand(merchandDTO));
        return MerchandMapper.toMerchandDTO(savedMerchand);
    }

    public MerchandDTO editMerchand(MerchandDTO merchandDTO) throws BusinessException{
        Merchand merchand = merchandRepository.findByName(merchandDTO.getName());
        if(merchand ==null)
            throw new BusinessException("M00001", CommonUtils.ERROR_BUSINESS.get("M00001"));
        Merchand savedMerchand = merchandRepository.save(MerchandMapper.toMerchand(merchandDTO));
        return MerchandMapper.toMerchandDTO(savedMerchand);
    }
}
