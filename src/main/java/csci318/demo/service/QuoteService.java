package csci318.demo.service;

import csci318.demo.model.Quote;
import csci318.demo.model.QuoteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    private ApplicationEventPublisher publisher;

    @Autowired
    public void QuoteService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void recordQuote(Quote quote) {
        QuoteEvent quoteEvent = new QuoteEvent(quote);
        publisher.publishEvent(quoteEvent);
    }

}
