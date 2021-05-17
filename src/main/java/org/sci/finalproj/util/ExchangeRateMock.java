package org.sci.finalproj.util;

public class ExchangeRateMock {
    public static double exchangeRateService(double amount, String cryptoCoinSymbol, Long defaultWalletCurrencyId) {
        return amount * Math.random();
    }
}
