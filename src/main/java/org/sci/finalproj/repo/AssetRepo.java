package org.sci.finalproj.repo;

import org.sci.finalproj.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepo extends CrudRepository<User, Long> {
}
