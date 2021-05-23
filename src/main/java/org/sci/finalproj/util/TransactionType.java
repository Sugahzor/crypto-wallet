package org.sci.finalproj.util;

public enum TransactionType {
    FICR,  /* fiat - crypto : buyCryptoAsset */
    CRCR,  /* crypto - crypto : exchangeCryptoAsset */
    CRFI,  /* crypto - fiat : exchangeCryptoAsset */
    FIFI   /* default - newFiat : buyFiatAsset  */
}
