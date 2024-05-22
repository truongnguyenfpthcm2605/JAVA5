package com.poly.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.poly.app.enity.Account;

public interface AccountRepository extends CrudRepository<Account, String> {

}
