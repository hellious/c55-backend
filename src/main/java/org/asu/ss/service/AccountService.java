package org.asu.ss.service;

import org.asu.ss.dao.AccountDAO;
import org.asu.ss.model.Account;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public void setAccountDAO(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public Account findAccountById(long id){
		return this.accountDAO.findAccountById(id);
	}
	
	public void saveAccount(Account account){
		this.accountDAO.saveAccount(account);
	}
	
}
