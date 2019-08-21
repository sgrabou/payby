package ma.payby.common.jpa.repository;

import ma.payby.common.jpa.model.Merchant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends PagingAndSortingRepository<Merchant, Long> {

    Merchant findByName(String name);
    Merchant findByUserName(String userName);
    @Override
    List<Merchant> findAll();
}
