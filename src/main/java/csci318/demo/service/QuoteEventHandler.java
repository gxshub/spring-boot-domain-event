package csci318.demo.service;

import csci318.demo.model.QuoteEvent;
import csci318.demo.repository.QuoteEventRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class QuoteEventHandler {

    private final QuoteEventRepository quoteEventRepository;

    QuoteEventHandler(QuoteEventRepository quoteEventRepository) {
        this.quoteEventRepository = quoteEventRepository;
    }

    @EventListener
    public void handle(QuoteEvent quoteEvent) {
        quoteEventRepository.save(quoteEvent);

    }

}
