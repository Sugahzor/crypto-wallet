package org.sci.finalproj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FiatCoin implements SuperCoin{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long fiatCoinId;
    String fiatCoinName;
    String fiatCoinSymbol;

    public FiatCoin(){
    }

    public FiatCoin(String fiatCoinName, String fiatCoinSymbol) {
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

    public void setFiatCoinSymbol(String fiatCoinSymbol) {
        this.fiatCoinSymbol = fiatCoinSymbol;
    }

    public String getCoinSymbol() {
        return fiatCoinSymbol;
    }

    public Long getCoinId() {
        return fiatCoinId;
    }
}
