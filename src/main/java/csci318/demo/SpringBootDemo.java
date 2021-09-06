package csci318.demo;

import csci318.demo.model.Quote;
import csci318.demo.service.QuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootDemo {

	private static final Logger log = LoggerFactory.getLogger(SpringBootDemo.class);
	@Autowired
	private QuoteService quoteService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo.class, args);
	}

	// With @Bean annotation of the following method, a RestTemplate object is injected.
	// But there is no need to define a separate method to return a RestTemplateBuilder object.
	// This is due to the following reason:
	// "In a typical auto-configured Spring Boot application
	// this builder is available as a bean and can be injected
	// whenever a RestTemplate is needed." -- from RestTemplateBuilder API Doc
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			//get 10 quotes
			for (int i=0; i<10; i++) {
				Quote quote = restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", Quote.class);
				assert quote != null;
				log.info(quote.toString());
				quoteService.recordQuote(quote);
			}
		};
	}

}
