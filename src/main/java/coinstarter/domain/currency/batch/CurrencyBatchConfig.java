package coinstarter.domain.currency.batch;

import coinstarter.jpa.currency.CurrencyRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "batch.currency.enabled", value = "true")
public class CurrencyBatchConfig {

    @Bean
    public CurrencyBatchExecutor currencyBatchExecutor(CurrencyRepository currencyRepository, CurrencyBatchProperties properties) {
        return new CurrencyBatchExecutor(currencyRepository, properties);
    }

    @Bean
    public CurrencyBatchProperties currencyBatchProperties() {
        return new CurrencyBatchProperties();
    }

}
