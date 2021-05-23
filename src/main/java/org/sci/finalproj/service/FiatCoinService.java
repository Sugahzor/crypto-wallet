package org.sci.finalproj.service;

import org.sci.finalproj.model.FiatCoin;
import org.sci.finalproj.repo.FiatCoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiatCoinService {
    @Autowired
    private FiatCoinRepo fiatCoinRepo;

    public List<FiatCoin> getFiatCoinList() {
        List<FiatCoin> fiatCoinList = new ArrayList<>();
        fiatCoinRepo.findAll().forEach(fiatCoin -> fiatCoinList.add(fiatCoin));
        return fiatCoinList;
    }

    public FiatCoin getFiatCoinBySymbol(String coinSymbol) {
        return fiatCoinRepo.findByFiatCoinSymbol(coinSymbol);
    }
}
