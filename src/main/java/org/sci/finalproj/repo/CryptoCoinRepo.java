package org.sci.finalproj.repo;

import org.sci.finalproj.model.CryptoCoin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CryptoCoinRepo extends CrudRepository<CryptoCoin, Long> {

    public CryptoCoin findByCryptoCoinSymbol(String cryptoCoinSymbol);
    public CryptoCoin findByCryptoCoinId(Long cryptoCoinId);
    public Iterable<CryptoCoin> findAll();
    public CryptoCoin save(CryptoCoin newCryptoCoin);
}
