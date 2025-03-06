package inspiration.inspi_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import inspiration.inspi_api.model.Quote;
import inspiration.inspi_api.service.QuoteService;

@RestController
public class QuoteController {
	QuoteService quoteService;
	
	public QuoteController(QuoteService quoteService) {
		this.quoteService = quoteService;
	}
	
	@GetMapping("/getQuote")
	public Quote getQuote() {
		return quoteService.getGuote();
	}
}
