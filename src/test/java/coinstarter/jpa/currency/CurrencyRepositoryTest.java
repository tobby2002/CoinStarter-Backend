package coinstarter.jpa.currency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyRepositoryTest {

    @Autowired
    private CurrencyRepository repository;

    @Test
    public void save() throws Exception {
        Currency currency = Currency.builder()
                                    .currencyType(CurrencyTypes.BTC_KRW)
                                    .build();

        Currency result = repository.save(currency);

        assertThat(result.getCurrencyType()).isEqualTo(CurrencyTypes.BTC_KRW);
    }
}