package coinstarter.domain.currency.service;

import coinstarter.domain.currency.repository.Currency;
import coinstarter.domain.currency.repository.CurrencyTypes;

public interface CurrencyService {
    Currency getLastCurrency(CurrencyTypes currency);
}
