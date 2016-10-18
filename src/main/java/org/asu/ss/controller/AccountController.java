package org.asu.ss.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.asu.ss.model.Account;
import org.asu.ss.model.BackendResponse;
import org.asu.ss.model.Login;
import org.asu.ss.service.AccountService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(value = "/account/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> addAccount(@RequestBody Account account, UriComponentsBuilder ucb) {

		/*
		 * Check if the customer already exists and act accordingly
		 */
		Date date = new Date();
		try {
			account.setCreation_date(date);
			accountService.saveAccount(account);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucb.path("account/{id}").buildAndExpand(account.getAcc_no()).toUri());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Account>(account, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/account/view", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BackendResponse> getAccount(@RequestBody Account account, UriComponentsBuilder ucb) {
		
		BackendResponse backendResponse = new BackendResponse();
		Account retAccount = accountService.findAccountById(account.getAcc_no());
		if (retAccount == null) {
			backendResponse.setStatus("Failure");
			backendResponse.setError("Account not found!!");
			return new ResponseEntity<BackendResponse>(backendResponse, HttpStatus.NOT_FOUND);
		}
		backendResponse.setStatus("Success");
		backendResponse.setData(retAccount);
		return new ResponseEntity<BackendResponse>(backendResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/account/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccount(@PathVariable("id") long id) {

		Account account = accountService.findAccountById(id);
		if (account == null) {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	//testing ajax call
	@RequestMapping(value = "/admin/doAjax", method = RequestMethod.GET )
	public @ResponseBody
	String doAjax(  HttpServletRequest request) {
		//model.addAttribute("login", new Login());
		HttpSession session = request.getSession();
	    String username = (String)session.getAttribute("username");
	    //session.setAttribute("UserName", username);
		String s=request.getRequestURI();
		String id=session.getId();
		System.out.println("url=="+s);
		//HttpSession session= request.getSession(true);
		System.out.println(session.getId());
		
		
		System.out.println("I was in Ajax Call method");
		
		
		return username+"I was in Ajax Call method"+id;
		
		
	}
	
	@RequestMapping(value = "/admin/RoleAddition",method = RequestMethod.POST)
	public String testLink() {

		System.out.println("In testLink");
		return "RoleAddition";
	}
	@RequestMapping(value = "/admin/RoleAddition",method = RequestMethod.GET)
	public String testLink1() {

		System.out.println("In testLink1");
		return "admin/RoleAddition";
	}
	@RequestMapping(value = "/RoleAddition",method = RequestMethod.GET)
	public String testLink2() {

		System.out.println("In testLink2");
		return "RoleAddition";
	}
	@RequestMapping(value = "/RoleAddition",method = RequestMethod.POST)
	public String testLink3() {

		System.out.println("In testLink3");
		return "RoleAddition";
	}
	
	

}
