package com.mvc.hell;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value="/page")
	public String guestPage() {
		return "page";
	}
	@RequestMapping(value="/user/page")
	public String userPage() {
		return "user/page";
	}
	@RequestMapping(value="/member/page")
	public String memberPage() {
		return "member/page";
	}
	@RequestMapping(value="/admin/page")
	public String adminPage() {
		return "admin/page";
	}
}
