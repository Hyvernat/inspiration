package inspiration.inspi_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import inspiration.inspi_api.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
}
