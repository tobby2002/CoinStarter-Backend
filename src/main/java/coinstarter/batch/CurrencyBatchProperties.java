package coinstarter.batch;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.Min;

@Data
@ConfigurationProperties(prefix = "batch.currency")
public class CurrencyBatchProperties {

    private boolean enabled;

    @Min(500)
    private long initialDelay;

    @Min(5000)
    private long period;
}
