package coinstarter.domain.currency.service;

import coinstarter.domain.currency.repository.CurrencyRepository;
import coinstarter.jpa.currency.Currency;
import coinstarter.jpa.currency.CurrencyTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository repository;

    @Override
    public Currency getLastCurrency(CurrencyTypes currencyType) {
        return repository.findByCurrencyTypeOrderByTimestamp(currencyType);
    }

}
