package coinstarter.batch;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RestTemplateTest {

    private RestTemplate restTemplate;

    private String TEST_URL = "https://api.korbit.co.kr/v1/ticker/detailed?currency_pair=btc_krw";

    @Before
    public void setUp() throws Exception {
        CloseableHttpClient httpClient
            = HttpClients.custom()
                         .setSSLHostnameVerifier(new NoopHostnameVerifier())
                         .build();
        HttpComponentsClientHttpRequestFactory requestFactory
            = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);

        restTemplate = new RestTemplate(requestFactory);
    }

    @Test(timeout = 3000)
    public void httpCall() throws Exception {
        ResponseEntity<String> result = restTemplate.getForEntity(TEST_URL, String.class);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
