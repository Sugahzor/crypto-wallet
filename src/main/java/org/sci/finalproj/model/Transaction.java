package org.sci.finalproj.model;

import org.sci.finalproj.util.TransactionType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long transactionId;
    Long userId;
    Long oldCurrencyId;
    Long newCurrencyId;
    TransactionType transactionType;
    Double transactionAmount;
    Date executionDate;

    public Transaction(){
    }

    public Transaction(Long userId, Long oldCurrencyId, Long newCurrencyId, TransactionType transactionType, Double transactionAmount, Date executionDate) {
        this.userId = userId;
        this.oldCurrencyId = oldCurrencyId;
        this.newCurrencyId = newCurrencyId;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.executionDate = executionDate;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOldCurrencyId() {
        return oldCurrencyId;
    }

    public void setOldCurrencyId(Long oldCurrencyId) {
        this.oldCurrencyId = oldCurrencyId;
    }

    public Long getNewCurrencyId() {
        return newCurrencyId;
    }

    public void setNewCurrencyId(Long newCurrencyId) {
        this.newCurrencyId = newCurrencyId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }
}
