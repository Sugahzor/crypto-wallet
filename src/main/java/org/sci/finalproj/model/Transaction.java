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
    String oldCurrencySymbol;
    String newCurrencySymbol;
    TransactionType transactionType;
    Double transactionAmount;
    Date executionDate;

    public Transaction(){
    }

    public Transaction(Long userId, String oldCurrencySymbol, String newCurrencySymbol, TransactionType transactionType, Double transactionAmount, Date executionDate) {
        this.userId = userId;
        this.oldCurrencySymbol = oldCurrencySymbol;
        this.newCurrencySymbol = newCurrencySymbol;
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

    public String getOldCurrencySymbol() {
        return oldCurrencySymbol;
    }

    public void setOldCurrencySymbol(String oldCurrencySymbol) {
        this.oldCurrencySymbol = oldCurrencySymbol;
    }

    public String getNewCurrencySymbol() {
        return newCurrencySymbol;
    }

    public void setNewCurrencySymbol(String newCurrencySymbol) {
        this.newCurrencySymbol = newCurrencySymbol;
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
