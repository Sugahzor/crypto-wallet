package org.sci.finalproj.repo;

import org.sci.finalproj.model.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepo extends CrudRepository<Asset, Long> {
    public Asset save(Asset asset); /* both POST and PUT ? */
    public Asset findByCoinId(Long coinId);
    public void deleteById(Long assetId);
}
