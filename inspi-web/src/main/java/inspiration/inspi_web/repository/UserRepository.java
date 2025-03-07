package inspiration.inspi_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inspiration.inspi_web.model.User;
@Repository
public interface UserRepository extends JpaRepository<User , Integer> {
	User findByName(String name);
}
