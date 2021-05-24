package org.sci.finalproj.util;

public class ExchangeRateMock {
    public static double exchangeRateService(double amount, String superCoinSymbol, String defaultCurrencySymbol) {
        return amount * Math.random();
    }
}
