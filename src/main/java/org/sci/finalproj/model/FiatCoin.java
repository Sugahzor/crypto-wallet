package org.sci.finalproj.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FiatCoin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long fiatCoinId;
    String fiatCoinName;
    String fiatCoinSymbol;

    public FiatCoin(Long fiatCoinId, String fiatCoinName, String fiatCoinSymbol) {
        this.fiatCoinId = fiatCoinId;
        this.fiatCoinName = fiatCoinName;
        this.fiatCoinSymbol = fiatCoinSymbol;
    }

    public Long getFiatCoinId() {
        return fiatCoinId;
    }

    public void setFiatCoinId(Long fiatCoinId) {
        this.fiatCoinId = fiatCoinId;
    }

    public String getFiatCoinName() {
        return fiatCoinName;
    }

    public void setFiatCoinName(String fiatCoinName) {
        this.fiatCoinName = fiatCoinName;
    }

    public String getFiatCoinSymbol() {
        return fiatCoinSymbol;
    }

    public void setFiatCoinSymbol(String fiatCoinSymbol) {
        this.fiatCoinSymbol = fiatCoinSymbol;
    }
}
