package inspiration.inspi_api.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import inspiration.inspi_api.model.Quote;
import inspiration.inspi_api.repository.QuoteRepository;

@Service
public class QuoteService {
	QuoteRepository quoteRepository;

	public QuoteService(QuoteRepository quoteRepository) {
		this.quoteRepository = quoteRepository;
	}

	public Quote getGuote() {
		List<Quote> quotes = quoteRepository.findAll();

		Random random = new Random();

		return quotes.get(random.nextInt(quotes.size()));
	}
}