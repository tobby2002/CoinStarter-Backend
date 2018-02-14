package coinstarter.domain.currency.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Currency findByCurrencyTypeOrderByTimestamp(CurrencyTypes currencyType);
}
