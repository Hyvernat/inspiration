package inspiration.inspi_web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inspiration.inspi_web.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
	List<Message>findByUserId(Integer id);
}
