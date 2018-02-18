package coinstarter.api;

import coinstarter.domain.currency.repository.Currency;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import support.test.AcceptanceTest;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyAcceptanceTest extends AcceptanceTest {

    @Test
    public void getLastTicker() {
        ResponseEntity<Currency> response = template().getForEntity("/currencies/BTC_KRW/last", Currency.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void getLastTicker_NOTFOUND() {
        ResponseEntity<Currency> response = template().getForEntity("/currencies/ETH_KRW/last", Currency.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void getLastTicker_잘못된요청() {
        ResponseEntity<Currency> response = template().getForEntity("/currencies/BTC/last", Currency.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

}