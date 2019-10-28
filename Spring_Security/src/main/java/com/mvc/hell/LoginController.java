package com.mvc.hell;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value="/loginform", method= {RequestMethod.GET,RequestMethod.POST})
	public String loginForm() {
		return "login/loginform";
	}
	
	@RequestMapping(value="/loginfail", method= {RequestMethod.GET})
	public String loginfail() {
		return "login/loginfail";
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutform() {
		return "logout";
	}
	@RequestMapping(value="loginsuccess",method=RequestMethod.GET)
	public String loginresult() {
		return "login/loginsuccess";
	}
	@RequestMapping(value="/roleError")
	public String roleError() {
		return "/error/roleError";
	}
	
}
