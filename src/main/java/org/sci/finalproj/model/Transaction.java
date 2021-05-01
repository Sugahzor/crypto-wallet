package org.sci.finalproj.model;

import org.sci.finalproj.util.TransactionType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

public class Transaction {
//    transactionId
//    userId
//            (transactionType )
//    transactionAmmount
//            oldCurrencyId
//    newCurrencyId
//            executionDate
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long transactionId;
    Long userId;
    Long oldCurrencyId;
    Long newCurrencyId;
    TransactionType transactionType;
    Double transactionAmmount;
    Date executionDate;

    public Transaction(Long transactionId, Long userId, Long oldCurrencyId, Long newCurrencyId, TransactionType transactionType, Double transactionAmmount, Date executionDate) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.oldCurrencyId = oldCurrencyId;
        this.newCurrencyId = newCurrencyId;
        this.transactionType = transactionType;
        this.transactionAmmount = transactionAmmount;
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

    public Double getTransactionAmmount() {
        return transactionAmmount;
    }

    public void setTransactionAmmount(Double transactionAmmount) {
        this.transactionAmmount = transactionAmmount;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }
}
