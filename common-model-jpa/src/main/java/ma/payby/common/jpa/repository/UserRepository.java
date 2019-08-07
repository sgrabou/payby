package ma.payby.common.jpa.repository;

import ma.payby.common.jpa.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User save(User manager);

	User findByName(String name);
	@Override
	List<User> findAll();
}
