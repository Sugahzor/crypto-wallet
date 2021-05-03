package org.sci.finalproj.repo;

import org.sci.finalproj.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends CrudRepository<Transaction, Long> {
    public Transaction save(Transaction transaction);

    public List<Transaction> findAll();

    //attempt to query given a date selected by the user form interface
    //eg: get TransactionHistory for userSelectedExecutionDate = 20.04.2021
    @Query("SELECT u FROM Transaction u WHERE u.executionDate = :#{#userSelectedExecutionDate}")
    public Transaction specificDateQuery(@Param("userSelectedExecutionDate") Transaction transaction);
}
