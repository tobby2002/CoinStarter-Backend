package coinstarter.api;

import coinstarter.domain.currency.service.CurrencyService;
import coinstarter.jpa.currency.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/{currency}/last")
    public ResponseEntity<Currency> getLastTicker(@PathVariable String currency) {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(null);
    }

}
