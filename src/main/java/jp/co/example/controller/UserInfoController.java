package jp.co.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
import enums.LogEnum;
import jp.co.example.entity.Users;
import lombok.extern.slf4j.Slf4j;
import util.Util;

/**
 * userchangeへの遷移 2017/06/05
 *
 * @Author sakata
 */

@Slf4j
@Controller
public class UserInfoController {

	@Autowired
	private

	@RequestMapping("/userinfo")
	public String getUserInfo() { // セッションからユーザの値を取得する
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Users user = new Users();
		user.setUserId(1);

		return JspPage.USERINFO.getPageName();
	}

	// @RequestMapping(value="/userinfo", method=RequestMethod.POST)
	// public String postUserInfo() {
	// log.info(Util.getMethodName() + LogEnum.START.getLogValue());
	//
	// return JspPage.USERINFO.getPageName();
	// }

}