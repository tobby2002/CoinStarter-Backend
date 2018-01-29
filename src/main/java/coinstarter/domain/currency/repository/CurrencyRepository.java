package coinstarter.domain.currency.repository;

import coinstarter.jpa.currency.Currency;
import coinstarter.jpa.currency.CurrencyTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Currency findByCurrencyTypeOrderByTimestamp(CurrencyTypes currencyType);
}
