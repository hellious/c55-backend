package org.asu.ss.service;

import org.asu.ss.dao.LoginDAO;
import org.asu.ss.model.ExternalUser;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginService {

	@Autowired
	private LoginDAO loginDAO;

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public ExternalUser validateExtUser(String username, String password) {
		return loginDAO.getExtUser(username, password);
	}

}
