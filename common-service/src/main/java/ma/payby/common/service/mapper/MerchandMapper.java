package ma.payby.common.service.mapper;

import ma.payby.common.dto.MerchandDTO;
import ma.payby.common.jpa.model.Merchand;
import org.springframework.beans.BeanUtils;

public class MerchandMapper {
    public static MerchandDTO toMerchandDTO(Merchand merchand){
        MerchandDTO merchandDTO = new MerchandDTO();
        BeanUtils.copyProperties(merchand, merchandDTO);
        return merchandDTO;
    }

    public static Merchand toMerchand(MerchandDTO merchandDTO){
        Merchand merchand = new Merchand();
        BeanUtils.copyProperties(merchandDTO, merchand);
        return merchand;
    }
}
