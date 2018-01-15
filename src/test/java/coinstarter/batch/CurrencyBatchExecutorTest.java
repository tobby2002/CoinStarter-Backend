package coinstarter.batch;

import coinstarter.domain.currency.repository.CurrencyRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyBatchExecutorTest {

    @Autowired
    private CurrencyRepository repository;

}