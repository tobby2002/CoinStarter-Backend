package coinstarter.domain.currency.service;

import coinstarter.domain.currency.repository.Currency;
import coinstarter.domain.currency.repository.CurrencyRepository;
import coinstarter.domain.currency.repository.CurrencyTypes;
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
