package coinstarter.domain.currency.batch;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "batch.currency")
public class CurrencyBatchProperties {

    private long initialDelay;

    private long period;
}
