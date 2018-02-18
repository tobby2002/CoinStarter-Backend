package coinstarter.domain.currency.service;

import coinstarter.common.exception.CurrencyNotFoundException;
import coinstarter.domain.currency.repository.Currency;
import coinstarter.domain.currency.repository.CurrencyTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CurrencyServiceTest {

    @Autowired
    private CurrencyService currencyService;

    @Test
    public void getLastCurrency() throws Exception {
        Currency dbCurrency = currencyService.getLastCurrency(CurrencyTypes.BTC_KRW);

        assertThat(dbCurrency).isNotNull();
        assertThat(dbCurrency.getId()).isEqualTo(1);
    }

    @Test(expected = CurrencyNotFoundException.class)
    public void getLastCurrency_NOT_FOUND() throws Exception {
        currencyService.getLastCurrency(CurrencyTypes.ETC_KRW);
    }
}