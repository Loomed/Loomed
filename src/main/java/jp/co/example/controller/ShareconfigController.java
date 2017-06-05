package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;

@Controller
public class ShareconfigController {

	//homeからの遷移
	@RequestMapping("/shareconfig")
	public String getShare() {
		return JspPage.SHARECONFIG.getPageName();
	}



}