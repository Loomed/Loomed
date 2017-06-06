package jp.co.example.controller;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import enums.*;
import jp.co.example.entity.*;
import jp.co.example.form.*;
import jp.co.example.myTest.*;
import jp.co.example.service.*;
import lombok.extern.slf4j.*;
import util.*;

@Slf4j
@Controller
public class UserInfoController {

	@Autowired
	private MyUserService myUserService;
	@Autowired
	private MyUsersService myUsersService;

	@ModelAttribute("indexForm")
	private UserChangeForm setUpForm() {
		return new UserChangeForm();
	}

	/**
	 * userinfoへの遷移 2017/06/05
	 * @Author sakata
	 */
	@RequestMapping("/userinfo")
	public String getUserInfo(Model model) { // 引数の
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//本来ならセッションのユーザ値を使用する
		Users user = new Users();
		user.setUserId(1);
		Users user2 = myUsersService.getUser(user);


		model.addAttribute("user", user2);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.USERINFO.getPageName();
	}

	/**
	 * userinfoへの遷移 2017/06/05
	 * userchangeから遷移
	 * usersテーブル、mapテーブルそれぞれに更新をかける
	 * @Author sakata
	 */
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
	public String postUserInfo(@Valid UserChangeForm userChangeForm) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		//ログ表示
		getUserLog(userChangeForm);

		myUserService.Update(userChangeForm);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.USERINFO.getPageName();
	}

	private void getUserLog(UserChangeForm user)
	{
		log.info("user userId   : " + user.getUserId());
		log.info("user password : " + user.getPassword());
		log.info("user userName : " + user.getUserName());
		log.info("user authority: " + user.getAuthority());
		log.info("user companyId: " + user.getCompanyId());
		log.info("user training : " + user.getTraining());

	}
}