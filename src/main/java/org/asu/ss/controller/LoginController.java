package org.asu.ss.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.asu.ss.model.ExternalUser;
import org.asu.ss.model.Login;
import org.asu.ss.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	//, produces= MediaType.APPLICATION_JSON_VALUE
	
	@RequestMapping(value = {"/","/index"})
	public String Welcome(Model model, HttpServletRequest request){
		model.addAttribute("login", new Login());
		HttpSession session= request.getSession(false);
		String s = null;
		model.addAttribute("string",s);
		SecurityContextHolder.clearContext();
		System.out.println("Welcome");
		if(session != null) {
			System.out.println(session.getId());
			session.invalidate();
        }
		return "index";
	}
	
	@RequestMapping(value = "login/externaluser", method = RequestMethod.GET)
	public String getterCall(@ModelAttribute("login") Login login, Model model) {
		model.addAttribute("login", new Login());
		System.out.println("Welcome");
		return "redirect:/";
	}
	@SuppressWarnings("deprecation")
//	@RequestMapping(value = "login/externaluser", method = RequestMethod.POST)
//	public String validateLoginCredentials(@ModelAttribute("login") Login login, Model model, HttpServletRequest request) {
//		HttpSession session= request.getSession(true);
//			System.out.println(session.getId());
//			
//		try {
//			ExternalUser user = loginService.validateExtUser(login.getUname(), login.getPass());
//			System.out.println(login.getPass());
//			
//			System.out.println(session.getValue("user"));
//			if(user != null){
//				System.out.println("found");
//				return "redirect:/";
//			}else{
//				System.out.println("not found");
//				model.addAttribute("user", user);
//				return "accounts";
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "redirect:/";
//		}
//		
//	}
	@RequestMapping(value = "login/admin", method = RequestMethod.POST)
	public String validateLoginCredentialsAdmin(@ModelAttribute("login") Login login, Model model, HttpServletRequest request) {
		HttpSession session= request.getSession(true);
			System.out.println(session.getId());
			
		try {
			String s=request.getRequestURI();
			System.out.println("url=="+s);
			ExternalUser user = loginService.validateExtUser(login.getUname(), login.getPass());
			System.out.println(login.getPass());
			
			System.out.println(session.getValue("user"));
			if(user != null){
				System.out.println("found");
				return "redirect:/";
			}else{
				System.out.println("not found");
				session.setAttribute("username", "Prabhat");
				System.out.println(session.getAttribute("username"));
				model.addAttribute("user", user);
				return "admin/AdminHome";
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/";
		}
		
	}
//	//testing ajax call
//		@RequestMapping(value = "/admin/doAjax", method = RequestMethod.GET)
//		public @ResponseBody
//		String doAjax( Model model, HttpServletRequest request) {
//			String s=request.getRequestURI();
//			System.out.println("url=="+s);
//			HttpSession session= request.getSession(true);
//			System.out.println(session.getId());
//			model.addAttribute("login", new Login());
//			System.out.println("I am in Ajax Call method");
//			return "I am in Ajax Call method";
//		}

	
	
}
