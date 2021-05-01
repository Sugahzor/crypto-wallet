package org.sci.finalproj.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CryptoCoin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long cryptoCoinId;
    String cryptoCoinName;
    String cryptoCoinSymbol;

    public CryptoCoin(Long cryptoCoinId, String cryptoCoinName, String cryptoCoinSymbol) {
        this.cryptoCoinId = cryptoCoinId;
        this.cryptoCoinName = cryptoCoinName;
        this.cryptoCoinSymbol = cryptoCoinSymbol;
    }

    public Long getCryptoCoinId() {
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

    public String getCryptoCoinSymbol() {
        return cryptoCoinSymbol;
    }

    public void setCryptoCoinSymbol(String cryptoCoinSymbol) {
        this.cryptoCoinSymbol = cryptoCoinSymbol;
    }
}
