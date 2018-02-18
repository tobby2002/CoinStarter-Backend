package coinstarter.batch;

import coinstarter.domain.currency.repository.Currency;
import coinstarter.domain.currency.repository.CurrencyRepository;
import coinstarter.domain.currency.repository.CurrencyTypes;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

public class CurrencyBatchThread implements Runnable {

    private final CurrencyRepository currencyRepository;

    private final String ROOT_URL = "https://api.korbit.co.kr/v1/ticker/detailed?currency_pair=";

    private final RestTemplate restTemplate;

    private final ObjectMapper mapper;

    public CurrencyBatchThread(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
        this.restTemplate = new RestTemplate(getHttpRequestFactory());
        this.mapper = new ObjectMapper();
    }

    @Override
    public void run() {
        Arrays.stream(CurrencyTypes.values())
              .forEach(this::fetchCurrencyInfo);
    }

    private HttpComponentsClientHttpRequestFactory getHttpRequestFactory() {
        CloseableHttpClient httpClient = HttpClients.custom()
                                                    .setSSLHostnameVerifier(new NoopHostnameVerifier())
                                                    .build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        return requestFactory;
    }

    private void fetchCurrencyInfo(CurrencyTypes currencyTypes) {
        ResponseEntity<String> result = restTemplate.getForEntity(ROOT_URL + currencyTypes.getValue(), String.class);

        if (result.getStatusCode() == HttpStatus.OK) {
            saveCurrency(result.getBody(), currencyTypes);
        }
    }

    private void saveCurrency(String body, CurrencyTypes currencyTypes) {
        try {
            Currency currency = mapper.readValue(body, Currency.class);
            currency.setCurrencyType(currencyTypes);

            currencyRepository.save(currency);
        } catch (IOException ignored) {
        }
    }

}
