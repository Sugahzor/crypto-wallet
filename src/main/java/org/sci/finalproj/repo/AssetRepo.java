package org.sci.finalproj.repo;

import org.sci.finalproj.model.Asset;
import org.sci.finalproj.model.Transaction;
import org.sci.finalproj.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepo extends CrudRepository<Asset, Long> {
    public Asset save(Asset asset);

    public Asset findByAssetId(Long cryptoId);
}
