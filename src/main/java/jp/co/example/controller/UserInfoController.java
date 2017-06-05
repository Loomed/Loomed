package jp.co.example.controller;

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

	@ModelAttribute("userChangeForm")
	private UserChangeForm setUpForm() {
		return new UserChangeForm();
	}

	/**
	 * userinfoへの遷移 2017/06/05
	 * @Author sakata
	 */
	@RequestMapping("/userinfo")
	public String getUserInfo(Model model) { // セッションからユーザの値を取得する
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

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
	 *
	 * @Author sakata
	 */
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
	public String postUserInfo(UserChangeForm userChangeForm) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		log.info("user : " + userChangeForm.getCompanyId());
		Users user = new Users();

		//myUserService.Update();


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.USERINFO.getPageName();
	}

}