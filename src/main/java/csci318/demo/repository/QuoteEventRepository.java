package csci318.demo.repository;

import csci318.demo.model.QuoteEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteEventRepository extends JpaRepository<QuoteEvent, Long> {
}
