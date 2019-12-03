package com.accountApi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountApi.api.modal.Account;

//TODO Class names never be in camelCasing, please fix this.
@Repository
public interface accountRepository extends JpaRepository<Account, Integer>{

}
