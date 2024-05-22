package com.poly.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.poly.app.enity.Account;

public interface AccountRepository extends CrudRepository<Account, String> {
	@Query("select o from Account o where o.username = ?1")
	Account findByUsernameLike(String username);
	
	
}

