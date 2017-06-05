package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
import enums.LogEnum;
import lombok.extern.slf4j.Slf4j;
import util.Util;

//login.jspへの遷移を記述
@Slf4j
@Controller
public class LoginController {

	//login.jspからの遷移
	@RequestMapping("/login")
	public String getLogin() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.LOGIN.getPageName();
	}

}