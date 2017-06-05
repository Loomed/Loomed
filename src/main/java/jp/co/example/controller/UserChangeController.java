package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
<<<<<<< HEAD
import enums.LogEnum;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
=======

>>>>>>> 453dcaf76f6b623ea717da9ae8658f0f08ca8088
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
=======
	* userinfoへの遷移
	* 2017/06/05
	* @Author sakata
	*/
	@RequestMapping("/userinfo")
	public String getUserInfo() {
		return JspPage.USERINFO.getPageName();
>>>>>>> 453dcaf76f6b623ea717da9ae8658f0f08ca8088
	}

}