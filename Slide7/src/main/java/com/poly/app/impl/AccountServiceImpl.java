package com.poly.app.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.app.enity.Account;
import com.poly.app.repository.AccountRepository;
import com.poly.app.service.AccountService;
@Service
public class AccountServiceImpl  implements AccountService{
	
	@Autowired
	AccountRepository dao;
	@Override
	public Account insert(Account ac) {
		return dao.save(ac);
	}
	@Override
	public Account update(Account ac) {
		return dao.save(ac);
	}
	@Override
	public void deleteId(String id) {
		dao.deleteById(id);
	}
	@Override
	public Optional<Account> getAccountbyId(String id) {
		return dao.findById(id);
	}
	@Override
	public List<Account> getAll() {
		return (List<Account>) dao.findAll();
		
	}
	@Override
	public Account findByUsername(String username) {
		return dao.findByUsernameLike(username);
	}

}
