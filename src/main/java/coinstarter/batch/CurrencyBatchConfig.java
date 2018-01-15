package coinstarter.batch;

import coinstarter.domain.currency.repository.CurrencyRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "batch.currency", name = "enabled", havingValue = "true")
@EnableConfigurationProperties(CurrencyBatchProperties.class)
public class CurrencyBatchConfig {

    @Bean
    public CurrencyBatchExecutor currencyBatchExecutor(CurrencyRepository currencyRepository, CurrencyBatchProperties properties) {
        return new CurrencyBatchExecutor(currencyRepository, properties);
    }
}
