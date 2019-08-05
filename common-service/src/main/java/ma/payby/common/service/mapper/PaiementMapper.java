package ma.payby.common.service.mapper;

import ma.payby.common.dto.PaiementDTO;
import ma.payby.common.jpa.model.Paiement;
import org.springframework.beans.BeanUtils;

public class PaiementMapper {
    public static PaiementDTO toPaiementDTO(Paiement paiement){
        PaiementDTO paiementDTO = new PaiementDTO();
        BeanUtils.copyProperties(paiement,paiementDTO);
        return paiementDTO;
    }

    public static Paiement toPaiement(PaiementDTO paiementDTO){
        Paiement paiement = new Paiement();
        BeanUtils.copyProperties(paiementDTO,paiement);
        return paiement;
    }
}
