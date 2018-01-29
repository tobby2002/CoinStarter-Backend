package coinstarter.api;

import coinstarter.common.exception.CurrencyNotFoundException;
import coinstarter.domain.currency.service.CurrencyService;
import coinstarter.jpa.currency.Currency;
import coinstarter.jpa.currency.CurrencyTypes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/{currency}/last")
    public ResponseEntity<Currency> getLastTicker(@PathVariable CurrencyTypes currencyType) {
        Currency currency = currencyService.getLastCurrency(currencyType);

        if (currency == null) {
            throw new CurrencyNotFoundException(currencyType.getValue());
        }

        return ResponseEntity.status(HttpStatus.OK)
                             .body(currency);
    }

}
