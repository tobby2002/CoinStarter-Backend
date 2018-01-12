package coinstarter.jpa.ticket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketRepositoryTest {

    @Autowired
    private TicketRepository repository;

    @Test
    public void save() throws Exception {
        Ticket ticket = Ticket.builder()
                              .name("test")
                              .build();

        Ticket result = repository.save(ticket);

        assertThat(result.getName()).isEqualTo("test");
    }
}