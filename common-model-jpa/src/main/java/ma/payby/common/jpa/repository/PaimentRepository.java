package ma.payby.common.jpa.repository;

import ma.payby.common.jpa.model.Paiement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaimentRepository extends PagingAndSortingRepository<Paiement, Long> {

    Paiement findByPaiementID(Long id);

    @Override
    List<Paiement> findAll();
}
