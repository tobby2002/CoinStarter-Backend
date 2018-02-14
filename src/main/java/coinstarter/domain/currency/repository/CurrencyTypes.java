package coinstarter.domain.currency.repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CurrencyTypes {
    BTC_KRW("btc_krw"),
    ETC_KRW("etc_krw"),
    ETH_KRW("eth_krw"),
    XRP_KRW("xrp_krw"),
    BCH_KRW("bch_krw");

    private final String value;

    public String getValue() {
        return this.value;
    }
}
