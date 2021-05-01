package org.sci.finalproj.repo;

import org.sci.finalproj.model.Transaction;
import org.sci.finalproj.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction, Long> {
    public Transaction save(Transaction transaction);

    //attempt to query given a date selected by the user form interface
    //eg: get TransactionHistory for userSelectedExecutionDate = 20.04.2021
    @Query("SELECT u FROM Transaction u WHERE u.executionDate = :#{#userSelectedExecutionDate}")
    public Transaction customQuery1(@Param("userSelectedExecutionDate") Transaction transaction);
}
