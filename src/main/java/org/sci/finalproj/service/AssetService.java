package org.sci.finalproj.service;

import org.sci.finalproj.model.*;
import org.sci.finalproj.repo.AssetRepo;
import org.sci.finalproj.repo.CryptoCoinRepo;
import org.sci.finalproj.repo.FiatCoinRepo;
import org.sci.finalproj.repo.TransactionRepo;
import org.sci.finalproj.util.ExchangeRateMock;
import org.sci.finalproj.util.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AssetService {

    @Autowired
    private AssetRepo assetRepo;
    @Autowired
    private CryptoCoinRepo cryptoCoinRepo;
    @Autowired
    private FiatCoinRepo fiatCoinRepo;
    @Autowired
    private TransactionRepo transactionRepo;

    public List<Asset> getAllAssets() {
        List<Asset> assetsList = new ArrayList<>();
        assetRepo.findAll().forEach(asset -> assetsList.add(asset));
        return assetsList;
    }

    public void buyCryptoAsset(double amount, String cryptoCoinSymbol, String defaultCurrencySymbol, Long userId) {
        Asset defaultAsset = assetRepo.findByCoinSymbol(defaultCurrencySymbol);
        if (defaultAsset != null && defaultAsset.getCoinAmount() >= amount) {
            if (defaultAsset.getCoinAmount() == amount) {
                assetRepo.deleteById(defaultAsset.getAssetId());
            } else {
                defaultAsset.setCoinAmount(defaultAsset.getCoinAmount() - amount);
            }
        } else {
            System.out.println("Please input card details: to be implemented; keep going for now");
        }

        Asset existentCryptoAsset = assetRepo.findByCoinSymbol(cryptoCoinSymbol);
        // add or update asset :
        if (existentCryptoAsset == null) {
            //add
            assetRepo.save(new Asset(userId, cryptoCoinSymbol, amount));
        } else {
            //update
            double existentAmount = existentCryptoAsset.getCoinAmount();
            existentCryptoAsset.setCoinAmount(existentAmount + amount);
        }
        // add transaction to DB :
        Date currentSqlDate = new Date(System.currentTimeMillis());
        transactionRepo.save(new Transaction(userId, defaultCurrencySymbol, cryptoCoinSymbol, TransactionType.FICR, amount, currentSqlDate));
    }

    public void exchangeCryptoAsset(double amount, String oldCoinSymbol, String newCoinSymbol, String defaultCurrencySymbol, Long userId) {
        CryptoCoin newCoinCrypto = cryptoCoinRepo.findByCryptoCoinSymbol(newCoinSymbol);
        Asset oldCoinAsset = assetRepo.findByCoinSymbol(oldCoinSymbol);

        double amountInDefaultCurrency = ExchangeRateMock.exchangeRateService(amount, oldCoinSymbol, defaultCurrencySymbol);

        // Set old coin asset - exit, delete or update
        double remainingOldCoinAmount = oldCoinAsset.getCoinAmount() - amount;
        if (remainingOldCoinAmount < 0) {
            System.out.println("Not enough balance. Max is: " + oldCoinAsset.getCoinAmount());
            return;
        } else {
            if (remainingOldCoinAmount == 0) {
                assetRepo.delete(oldCoinAsset);
            } else {
                oldCoinAsset.setCoinAmount(remainingOldCoinAmount);
            }
        }

        // Set intermediary (or final, if newCoin == defaultCurrency) defaultAsset
        Asset existentDefaultAsset = assetRepo.findByCoinSymbol(defaultCurrencySymbol);
        if (existentDefaultAsset != null) {
            double existingFiatAmount = existentDefaultAsset.getCoinAmount();
            existentDefaultAsset.setCoinAmount(existingFiatAmount + amountInDefaultCurrency);
        } else {
            Asset newAsset = new Asset(userId, defaultCurrencySymbol, amountInDefaultCurrency);
            assetRepo.save(newAsset);
        }

        // 3 cases of exchange, to : defaultFiatCurrency, new crypto, new fiat

        if (newCoinSymbol.equals(defaultCurrencySymbol)) {
            // CRFI transaction
            // add transaction to DB and exit; defaultAsset already set; oldCrypto already set
            Date currentSqlDate = new Date(System.currentTimeMillis());
            transactionRepo.save(new Transaction(userId, oldCoinSymbol, defaultCurrencySymbol, TransactionType.CRFI, amountInDefaultCurrency, currentSqlDate));
            return;
        }
        if (newCoinCrypto != null) {
            // new coin is a crypto
            // CRCR transaction : oldCR-defaultFI , defaultFI-newCR
            buyCryptoAsset(amountInDefaultCurrency, newCoinSymbol, defaultCurrencySymbol, userId);
        } else {
            // new coin is a fiat, but not default one
            // FIFI transaction
            buyFiatAsset(amountInDefaultCurrency, newCoinSymbol, defaultCurrencySymbol, userId);
        }
    }

    public void buyFiatAsset(double amountInDefaultCurrency, String newFiatSymbol, String defaultCurrencySymbol, Long userId) {
        Asset existentNewCoinAsset = assetRepo.findByCoinSymbol(newFiatSymbol);
        Asset defaultCurrencyAsset = assetRepo.findByCoinSymbol(defaultCurrencySymbol);
        double remainingDefaultAmount;

        if (defaultCurrencyAsset != null) {
            remainingDefaultAmount = defaultCurrencyAsset.getCoinAmount() - amountInDefaultCurrency;
        } else {
            System.out.println("Should not get here. Asset should be valid from exchangeCryptoAsset");
            return;
        }
        if (remainingDefaultAmount < 0) {
            System.out.println("Should not get here. Amount should be valid from exchangeCryptoAsset");
            return;
        }

        if (remainingDefaultAmount > 0) {
            defaultCurrencyAsset.setCoinAmount(remainingDefaultAmount);
        } else {
            assetRepo.delete(defaultCurrencyAsset);
        }

        double amountInNewFiat = ExchangeRateMock.exchangeRateService(amountInDefaultCurrency, newFiatSymbol, defaultCurrencySymbol);
        if (existentNewCoinAsset != null) {
            // update asset
            double existentAmount = existentNewCoinAsset.getCoinAmount();
            existentNewCoinAsset.setCoinAmount(existentAmount + amountInNewFiat);
        } else {
            // add asset
            Asset newCoinFiatAsset = new Asset(userId, newFiatSymbol, amountInNewFiat);
            assetRepo.save(newCoinFiatAsset);
        }

        // add transaction to DB
        String defaultCoinSymbol = defaultCurrencyAsset.getCoinSymbol();
        Date currentSqlDate = new Date(System.currentTimeMillis());
        transactionRepo.save(new Transaction(userId, defaultCoinSymbol, newFiatSymbol, TransactionType.FIFI, amountInDefaultCurrency,currentSqlDate));
    }

}
