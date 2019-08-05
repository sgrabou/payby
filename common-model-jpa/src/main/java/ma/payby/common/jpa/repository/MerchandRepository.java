package ma.payby.common.jpa.repository;

import ma.payby.common.jpa.model.Merchand;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchandRepository extends PagingAndSortingRepository<Merchand, Long> {

    Merchand findByName(String name);
    Merchand findByUserName(String userName);
    @Override
    List<Merchand> findAll();
}
