package org.sci.finalproj.repo;

import org.sci.finalproj.model.FiatCoin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiatCoinRepo extends CrudRepository<FiatCoin, Long> {

    public FiatCoin findByFiatCoinId(Long fiatCoinId);
    public FiatCoin findByFiatCoinSymbol(String fiatCoinSymbol);
    public Iterable<FiatCoin> findAll();
}
