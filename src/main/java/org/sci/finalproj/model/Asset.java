package org.sci.finalproj.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long assetId;
    Long userId;
    Long coinId;
    Double coinAmount;

    public Asset() {
    }

    public Asset(Long userId, Long coinId, Double coinAmount) {
        this.userId = userId;
        this.coinId = coinId;
        this.coinAmount = coinAmount;
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

    public Long getCoinId() {
        return coinId;
    }

    public void setCoinId(Long coinId) {
        this.coinId = coinId;
    }

    public Double getCoinAmount() {
        return coinAmount;
    }

    public void setCoinAmount(Double coinAmount) {
        this.coinAmount = coinAmount;
    }
}
