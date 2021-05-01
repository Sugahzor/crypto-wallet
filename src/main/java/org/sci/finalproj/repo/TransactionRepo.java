package org.sci.finalproj.repo;

import org.sci.finalproj.model.Transaction;
import org.sci.finalproj.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction, Long> {
    public Transaction save(Transaction transaction);
}
