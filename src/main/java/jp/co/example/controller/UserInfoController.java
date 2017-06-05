package jp.co.example.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 453dcaf76f6b623ea717da9ae8658f0f08ca8088
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
<<<<<<< HEAD
import enums.LogEnum;
import jp.co.example.entity.Users;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Controller
public class UserInfoController {

	@Autowired
	private

=======

@Controller
public class UserInfoController {

>>>>>>> 453dcaf76f6b623ea717da9ae8658f0f08ca8088
	/**
	* userchangeへの遷移
	* 2017/06/05
	* @Author sakata
	*/
<<<<<<< HEAD
	@RequestMapping("/userinfo")
	public String getUserInfo() { //セッションからユーザの値を取得する
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Users user = new Users();
		user.setUserId(1);



		return JspPage.USERINFO.getPageName();
	}

//	@RequestMapping(value="/userinfo", method=RequestMethod.POST)
//	public String postUserInfo() {
//		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
//
//		return JspPage.USERINFO.getPageName();
//	}

=======
	@RequestMapping("/userchange")
	public String getUserInfo() {
		return JspPage.USERCHANGE.getPageName();
	}

>>>>>>> 453dcaf76f6b623ea717da9ae8658f0f08ca8088
}