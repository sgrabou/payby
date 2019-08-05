package ma.payby.common.jpa.repository;

import ma.payby.common.jpa.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    Order findByOrderID(Long id);
    Order findByReference(String reference);

    @Override
    List<Order> findAll();
}
