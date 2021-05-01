package org.sci.finalproj.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Asset {
//
//
//
//
//
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long assetId;
    Long userId;
    Long defaultCurrencyStableCoinID;
    Long cryptoCoinId;
    Double cryptoCoinValue;

    public Asset(Long assetId, Long userId, Long defaultCurrencyStableCoinID, Long cryptoCoinId, Double cryptoCoinValue) {
        this.assetId = assetId;
        this.userId = userId;
        this.defaultCurrencyStableCoinID = defaultCurrencyStableCoinID;
        this.cryptoCoinId = cryptoCoinId;
        this.cryptoCoinValue = cryptoCoinValue;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDefaultCurrencyStableCoinID() {
        return defaultCurrencyStableCoinID;
    }

    public void setDefaultCurrencyStableCoinID(Long defaultCurrencyStableCoinID) {
        this.defaultCurrencyStableCoinID = defaultCurrencyStableCoinID;
    }

    public Long getCryptoCoinId() {
        return cryptoCoinId;
    }

    public void setCryptoCoinId(Long cryptoCoinId) {
        this.cryptoCoinId = cryptoCoinId;
    }

    public Double getCryptoCoinValue() {
        return cryptoCoinValue;
    }

    public void setCryptoCoinValue(Double cryptoCoinValue) {
        this.cryptoCoinValue = cryptoCoinValue;
    }
}
