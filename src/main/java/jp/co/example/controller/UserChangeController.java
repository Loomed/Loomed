package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;

@Controller
public class UserChangeController {

	/**
	* userinfoへの遷移
	* 2017/06/05
	* @Author sakata
	*/
	@RequestMapping("/userinfo")
	public String getUserInfo() {
		return JspPage.USERINFO.getPageName();
	}

}