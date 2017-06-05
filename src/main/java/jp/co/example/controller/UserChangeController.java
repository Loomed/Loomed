package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
import enums.LogEnum;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Controller
public class UserChangeController {

	/**
<<<<<<< HEAD
	* userchangeへの遷移
	* 2017/06/05
	* @Author sakata
	*/
	@RequestMapping("/userchange")
	public String getUserChange() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		return JspPage.USERCHANGE.getPageName();
	}

	@RequestMapping("/userinfo")
	public String getUserInfo() {
		return JspPage.USERINFO.getPageName();

	}

}