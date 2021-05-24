package org.sci.finalproj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CryptoCoin implements SuperCoin{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long cryptoCoinId;
    String cryptoCoinName;
    String cryptoCoinSymbol;

    public CryptoCoin(){
    }

    public CryptoCoin(String cryptoCoinName, String cryptoCoinSymbol) {
        this.cryptoCoinName = cryptoCoinName;
        this.cryptoCoinSymbol = cryptoCoinSymbol;
    }

    public Long getCoinId() {
        return cryptoCoinId;
    }

    public void setCryptoCoinId(Long cryptoCoinId) {
        this.cryptoCoinId = cryptoCoinId;
    }

    public String getCryptoCoinName() {
        return cryptoCoinName;
    }

    public void setCryptoCoinName(String cryptoCoinName) {
        this.cryptoCoinName = cryptoCoinName;
    }

    public void setCryptoCoinSymbol(String cryptoCoinSymbol) {
        this.cryptoCoinSymbol = cryptoCoinSymbol;
    }

    public String getCoinSymbol() {
        return cryptoCoinSymbol;
    }

}
