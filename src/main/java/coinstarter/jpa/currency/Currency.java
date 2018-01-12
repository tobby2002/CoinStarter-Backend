package coinstarter.jpa.currency;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Entity
public class Currency {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private CurrencyTypes currencyType;

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

    public Currency() {

    }

    private Currency(CurrencyTypes currencyType,
                     Date timestamp,
                     int last,
                     int bid,
                     int ask,
                     int low,
                     int high,
                     double volume,
                     int change, double changePercent) {
        this.currencyType = currencyType;
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

    public static CurrencyBuilder builder() {
        return new CurrencyBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Currency)) { return false; }

        Currency currency = (Currency) o;

        return id == currency.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    public static class CurrencyBuilder {
        private CurrencyTypes currencyType;

        private Date timestamp;

        private int last;

        private int bid;

        private int ask;

        private int low;

        private int high;

        private double volume;

        private int change;

        private double changePercent;

        public CurrencyBuilder currencyType(CurrencyTypes currencyType) {
            this.currencyType = currencyType;
            return this;
        }

        public CurrencyBuilder timestamp(Date timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public CurrencyBuilder last(int last) {
            this.last = last;
            return this;
        }

        public CurrencyBuilder bid(int bid) {
            this.bid = bid;
            return this;
        }

        public CurrencyBuilder ask(int ask) {
            this.ask = ask;
            return this;
        }

        public CurrencyBuilder low(int low) {
            this.low = low;
            return this;
        }

        public CurrencyBuilder high(int high) {
            this.high = high;
            return this;
        }

        public CurrencyBuilder volume(double volume) {
            this.volume = volume;
            return this;
        }

        public CurrencyBuilder change(int change) {
            this.change = change;
            return this;
        }

        public CurrencyBuilder changePercent(double changePercent) {
            this.changePercent = changePercent;
            return this;
        }

        public Currency build() {
            return new Currency(currencyType, timestamp, last, bid, ask, low, high, volume, change, changePercent);
        }

    }

}
