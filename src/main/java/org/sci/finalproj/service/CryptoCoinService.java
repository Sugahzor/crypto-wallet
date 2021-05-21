package org.sci.finalproj.service;

import org.sci.finalproj.model.CryptoCoin;
import org.sci.finalproj.repo.CryptoCoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoCoinService {
    @Autowired
    CryptoCoinRepo cryptoCoinRepo;

    public CryptoCoin getCryptoByID(Long cryptoId) {
        return cryptoCoinRepo.findByCryptoCoinId(cryptoId);
    }

    public List<CryptoCoin> getCryptoCoinList() {
        List<CryptoCoin> cryptoCoinList = new ArrayList<>();
        cryptoCoinRepo.findAll().forEach(cryptoCoin -> cryptoCoinList.add(cryptoCoin));
        return cryptoCoinList;
    }
}
