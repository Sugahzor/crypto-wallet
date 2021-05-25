package org.sci.finalproj.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sci.finalproj.model.CryptoCoin;
import org.sci.finalproj.model.FiatCoin;
import org.sci.finalproj.repo.CryptoCoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoCoinService {
    @Autowired
    CryptoCoinRepo cryptoCoinRepo;


    private static final Logger LOGGER = LogManager.getLogger(UserService.class);



    public void register(CryptoCoin cryptoCoin) {
        CryptoCoin existingCryptoCoin = cryptoCoinRepo.findByCryptoCoinSymbol(cryptoCoin.getCryptoCoinName());

        if(existingCryptoCoin==null||!existingCryptoCoin.getCryptoCoinName().equals(cryptoCoin.getCryptoCoinName())) {
            cryptoCoinRepo.save(cryptoCoin);
            LOGGER.info("Cryptocoin has been registered");
        } else {
            LOGGER.info("fiat is in DB");
        }
    }

    public List<CryptoCoin> getCryptoCoinList() {
        List<CryptoCoin> cryptoCoinList = new ArrayList<>();
        cryptoCoinRepo.findAll().forEach(cryptoCoin -> cryptoCoinList.add(cryptoCoin));
        return cryptoCoinList;
    }
}
