package jp.co.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;

public class RootHomeController {
	@RequestMapping("/roothome")
	public String getrootHome() {
		return JspPage.ROOTHOME.getPageName();
	}

}
