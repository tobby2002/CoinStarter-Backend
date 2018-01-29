package coinstarter.domain.currency.service;

import coinstarter.jpa.currency.Currency;
import coinstarter.jpa.currency.CurrencyTypes;

public interface CurrencyService {
    Currency getLastCurrency(CurrencyTypes currency);
}
