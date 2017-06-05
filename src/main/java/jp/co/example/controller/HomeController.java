package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String Home() {

		return JspPage.HOME.getPageName();
	}

}