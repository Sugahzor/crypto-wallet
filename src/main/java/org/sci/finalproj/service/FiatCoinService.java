package org.sci.finalproj.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sci.finalproj.model.FiatCoin;
import org.sci.finalproj.model.User;
import org.sci.finalproj.repo.FiatCoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiatCoinService {
    @Autowired
    private FiatCoinRepo fiatCoinRepo;

    private static final Logger LOGGER = LogManager.getLogger(UserService.class);



    public void register(FiatCoin fiatCoin) {
        FiatCoin existingFiat = fiatCoinRepo.findByFiatCoinSymbol(fiatCoin.getCoinSymbol());

        if(existingFiat==null||!existingFiat.getFiatCoinName().equals(fiatCoin.getFiatCoinName())) {
            fiatCoinRepo.save(fiatCoin);
            LOGGER.info("Fiat has been registered");
        } else {
            LOGGER.info("Fiat is in DB");
        }
    }

    public List<FiatCoin> getFiatCoinList() {
        List<FiatCoin> fiatCoinList = new ArrayList<>();
        fiatCoinRepo.findAll().forEach(fiatCoin -> fiatCoinList.add(fiatCoin));
        return fiatCoinList;
    }

    public FiatCoin getFiatCoinBySymbol(String coinSymbol) {
        return fiatCoinRepo.findByFiatCoinSymbol(coinSymbol);
    }
}
