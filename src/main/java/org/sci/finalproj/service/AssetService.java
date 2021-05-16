package org.sci.finalproj.service;

import org.sci.finalproj.model.*;
import org.sci.finalproj.repo.AssetRepo;
import org.sci.finalproj.repo.CryptoCoinRepo;
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
    private TransactionRepo transactionRepo;

    public List<Asset> getAllAssets() {
        List<Asset> assetsList = new ArrayList<>();
        assetRepo.findAll().forEach(asset -> assetsList.add(asset));
        return assetsList;
    }

    public void buyCryptoAsset(double amount, String cryptoCoinSymbol, Long defaultWalletCurrencyId, Long userId) {
        //Fiat wallet not implemented. Money taken from Credit Cards
        CryptoCoin cryptoCoin = cryptoCoinRepo.findByCryptoCoinSymbol(cryptoCoinSymbol);
        long cryptoId = cryptoCoin.getCryptoCoinId();
        Asset existentCryptoAsset = assetRepo.findByCoinId(cryptoId);

        // add or update asset
        if (existentCryptoAsset == null) {
            assetRepo.save(new Asset(userId, cryptoId, amount));
        } else {
            double existentCryptoAssetAmount = existentCryptoAsset.getCoinAmount();
            existentCryptoAsset.setCoinAmount(existentCryptoAssetAmount + amount);
            // delete existentCryptoAsset first or save() overwrites it...?
            assetRepo.save(existentCryptoAsset);
        }

        // add transaction to DB
        Date currentSqlDate = new Date(System.currentTimeMillis());
        transactionRepo.save(new Transaction(userId, defaultWalletCurrencyId, cryptoId, TransactionType.FICR, amount, currentSqlDate));
    }

    public void exchangeCryptoAsset(double amount, String oldCoinSymbol, String newCoinSymbol, Long defaultWalletCurrencyId, Long userId) {
        CryptoCoin oldCoin = cryptoCoinRepo.findByCryptoCoinSymbol(oldCoinSymbol);
        Long oldCoinId = oldCoin.getCryptoCoinId();
        Asset oldCoinAsset = assetRepo.findByCoinId(oldCoinId);

        double defaultCurrencyAmountFromOldCrypto = ExchangeRateMock.exchangeRateService(amount, oldCoinSymbol, defaultWalletCurrencyId);
        double newOldCoinAmount = oldCoinAsset.getCoinAmount() - amount;

        if (newOldCoinAmount >= 0) {
            oldCoinAsset.setCoinAmount(newOldCoinAmount);
            if (newOldCoinAmount == 0) {
                assetRepo.deleteById(oldCoinId);
            }
        } else {
            System.out.println("Not enough balance. Max is: " + oldCoinAsset.getCoinAmount());
            return;
        }

        if (newCoinSymbol.equals(defaultWalletCurrencyId)) {
            // CRFI transaction
            // Asset will exist because we create it by default, upon setting currency as default
            Asset existentFiatAsset = assetRepo.findByCoinId(defaultWalletCurrencyId);
            double existingFiatAmount = existentFiatAsset.getCoinAmount();
            existentFiatAsset.setCoinAmount(existingFiatAmount + defaultCurrencyAmountFromOldCrypto);
            // delete existentFiatAsset first or save() overwrites it...?
            assetRepo.save(existentFiatAsset);
        } else {
            // CRCR transaction : oldCR-FI , FI-newCR
            buyCryptoAsset(defaultCurrencyAmountFromOldCrypto, newCoinSymbol, defaultWalletCurrencyId, userId);
        }

        // add transaction to DB
        Date currentSqlDate = new Date(System.currentTimeMillis());
        transactionRepo.save(new Transaction(userId, defaultWalletCurrencyId, oldCoinId, TransactionType.CRFI, defaultCurrencyAmountFromOldCrypto, currentSqlDate));
    }

}
