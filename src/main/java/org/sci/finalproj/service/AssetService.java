package org.sci.finalproj.service;

import org.sci.finalproj.model.*;
import org.sci.finalproj.repo.AssetRepo;
import org.sci.finalproj.repo.CryptoCoinRepo;
import org.sci.finalproj.repo.TransactionRepo;
import org.sci.finalproj.util.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class AssetService {

    @Autowired
    private AssetRepo assetRepo;
    @Autowired
    private CryptoCoinRepo cryptoCoinRepo;
    @Autowired
    private TransactionRepo transactionRepo;



    public void buyCryptoAsset(double amount, String cryptoCoinSymbol, Long defaultWalletCurrencyId, Long userId) {
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

        //substract exchangeRateCryptoToDefault from FiatAsset

        // add transaction to DB
        Date currentSqlDate = new Date(System.currentTimeMillis());
        transactionRepo.save(new Transaction(userId, defaultWalletCurrencyId, cryptoId, TransactionType.FICR, amount, currentSqlDate));
    }

    public void exchangeCryptoAsset(double amount, String oldCoinSymbol, String newCoinSymbol, Long defaultWalletCurrencyId, Long userId) {
        CryptoCoin oldCoin = cryptoCoinRepo.findByCryptoCoinSymbol(oldCoinSymbol);
        Long oldCoinId = oldCoin.getCryptoCoinId();

        double exchangeRateOldCoinToDefault = 0.0; /* need exchangeRate oldCoin to default here */
        double defaultCurrencyAmountFromOldCrypto = amount * exchangeRateOldCoinToDefault;

        //substract amount from, and delete if needed (amount == oldCoinAsset.amount), oldCoinAsset

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

        Date currentSqlDate = new Date(System.currentTimeMillis());
        transactionRepo.save(new Transaction(userId, defaultWalletCurrencyId, oldCoinId, TransactionType.CRFI, defaultCurrencyAmountFromOldCrypto, currentSqlDate));
    }

}
