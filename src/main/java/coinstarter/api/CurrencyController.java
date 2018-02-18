package coinstarter.api;

import coinstarter.domain.currency.repository.Currency;
import coinstarter.domain.currency.repository.CurrencyTypes;
import coinstarter.domain.currency.service.CurrencyService;
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
    public ResponseEntity<Currency> getLastTicker(@PathVariable("currency") CurrencyTypes currencyType) {
        Currency currency = currencyService.getLastCurrency(currencyType);
        return ResponseEntity.status(HttpStatus.OK)
                             .body(currency);
    }

}
