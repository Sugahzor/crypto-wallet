package org.sci.finalproj.model;

import javax.persistence.*;

@Entity
public class User {
    private String userEmail;
    private String userName;
    private String userPassword;
    private Long userPhone;
    private Long defaultWalletCurrencyId;
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

    public Long getDefaultWalletCurrencyId() {
        return defaultWalletCurrencyId;
    }

    public void setDefaultWalletCurrencyId(Long defaultWalletCurrencyId) {
        this.defaultWalletCurrencyId = defaultWalletCurrencyId;
    }
}
