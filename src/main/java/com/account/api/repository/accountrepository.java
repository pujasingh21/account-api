package com.account.api.repository;

import com.account.api.modal.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface accountrepository extends JpaRepository<Account, Long> {

    //@Query
    //Account findById(Long accountId);

}
