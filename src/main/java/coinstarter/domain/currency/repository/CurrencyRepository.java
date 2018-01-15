package coinstarter.domain.currency.repository;

import coinstarter.jpa.currency.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
