package coinstarter.jpa.ticket;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date timestamp;

    private int last;

    private int bid;

    private int ask;

    private int low;

    private int high;

    private double volume;

    private int change;

    private double changePercent;

    public Ticket() {

    }

    private Ticket(String name,
                   Date timestamp,
                   int last,
                   int bid,
                   int ask,
                   int low,
                   int high,
                   double volume,
                   int change, double changePercent) {
        this.name = name;
        this.timestamp = timestamp;
        this.last = last;
        this.bid = bid;
        this.ask = ask;
        this.low = low;
        this.high = high;
        this.volume = volume;
        this.change = change;
        this.changePercent = changePercent;
    }

    public static TicketBuilder builder() {
        return new TicketBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Ticket)) { return false; }

        Ticket ticket = (Ticket) o;

        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    public static class TicketBuilder {
        private String name;

        private Date timestamp;

        private int last;

        private int bid;

        private int ask;

        private int low;

        private int high;

        private double volume;

        private int change;

        private double changePercent;

        public TicketBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TicketBuilder timestamp(Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public TicketBuilder last(int last) {
            this.last = last;
            return this;
        }

        public TicketBuilder bid(int bid) {
            this.bid = bid;
            return this;
        }

        public TicketBuilder ask(int ask) {
            this.ask = ask;
            return this;
        }

        public TicketBuilder low(int low) {
            this.low = low;
            return this;
        }

        public TicketBuilder high(int high) {
            this.high = high;
            return this;
        }

        public TicketBuilder volume(double volume) {
            this.volume = volume;
            return this;
        }

        public TicketBuilder change(int change) {
            this.change = change;
            return this;
        }

        public TicketBuilder changePercent(double changePercent) {
            this.changePercent = changePercent;
            return this;
        }

        public Ticket build() {
            return new Ticket(name, timestamp, last, bid, ask, low, high, volume, change, changePercent);
        }

    }

}
