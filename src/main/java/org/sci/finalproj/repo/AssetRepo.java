package org.sci.finalproj.repo;

import org.sci.finalproj.model.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepo extends CrudRepository<Asset, Long> {

    public Asset save(Asset asset); /* both POST and PUT ? */
    public Asset findByCoinSymbol(String coinSymbol);
    public void deleteById(Long assetId);
    public Iterable<Asset> findAll();

}
