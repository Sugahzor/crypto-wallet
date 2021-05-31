package org.sci.finalproj.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    private String userEmail;
    private String userName;
    private String userPassword;
    private Long userPhone;


//    Create the foreign key for default Wallet currency that should be the valued from fiat coin
    @ManyToOne
    @JoinColumn(name = "fiatCoinId", referencedColumnName = "fiatCoinId")
    private FiatCoin fiatCoinId;

//    private String defaultCurrencyId;

    private String defaultCurrencySymbol;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    public User() {
    }

    public User(String userEmail, String userName, String userPassword, Long userPhone, String defaultCurrencySymbol) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.defaultCurrencySymbol = defaultCurrencySymbol;
    }

    public String getUserEmail() {

        return userEmail;
    }

    public void setUserEmail(String userEmail) {

        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getDefaultCurrencySymbol() {
        return defaultCurrencySymbol;
    }

    public void setDefaultCurrencySymbol(String defaultCurrencySymbol) {
        this.defaultCurrencySymbol = defaultCurrencySymbol;
    }

//    public User getFiatCoinId() {
//        return fiatCoinId;
//    }
//
//    public void setFiatCoinId(User fiatCoinId) {
//        this.fiatCoinId = fiatCoinId;
//    }
//
//    public User getDefaultWalletCurrencyId() {
//        return defaultWalletCurrencyId;
//    }
//
//    public void setDefaultWalletCurrencyId(User defaultWalletCurrencyId) {
//        this.defaultWalletCurrencyId = defaultWalletCurrencyId;
//    }

//
    public FiatCoin getFiatCoinId() {
        return fiatCoinId;
    }

    public void setFiatCoinId(FiatCoin fiatCoinId) {
        this.fiatCoinId = fiatCoinId;
    }

//    public String getDefaultCurrencyId() {
//        return defaultCurrencyId;
//    }
//
//    public void setDefaultCurrencyId(String defaultCurrencyId) {
//        this.defaultCurrencyId = defaultCurrencyId;
//    }
}
