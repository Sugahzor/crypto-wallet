package org.sci.finalproj.repo;

import org.sci.finalproj.model.Asset;
import org.sci.finalproj.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepo extends CrudRepository<Asset, Long> {

//    @Query("FOREIGN KEY (userId) REFERENCES User(userId)")
//    public Asset customQuery();

    public Asset save(Asset asset); /* both POST and PUT ? */
    public Asset findByCoinId(Long coinId);
    public void deleteById(Long assetId);

}
