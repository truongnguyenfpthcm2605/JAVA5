package com.poly.app.service;

import java.util.List;
import java.util.Optional;


import com.poly.app.enity.Account;

public interface AccountService {
	Account insert(Account ac);
	Account update(Account ac);
	void deleteId(String id);
	Optional<Account> getAccountbyId(String id);
	List<Account> getAll();
	Account findByUsername(String username);
}
