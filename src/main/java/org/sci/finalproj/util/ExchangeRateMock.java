package org.sci.finalproj.util;

public class ExchangeRateMock {
    public static double exchangeRateService(double amount, String superCoinSymbol, Long defaultWalletCurrencyId) {
        return amount * Math.random();
    }
}
