package jp.co.example.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import enums.*;
import jp.co.example.entity.*;
import jp.co.example.myTest.*;
import lombok.extern.slf4j.*;
import util.*;

@Slf4j
@Controller
public class UserInfoController {

	@Autowired
	private MyUsersService myUserService;

	/**
	 * userchangeへの遷移 2017/06/05
	 *
	 * @Author sakata
	 */
	@RequestMapping("/userinfo")
	public String getUserInfo(Model model) { // セッションからユーザの値を取得する
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Users user = new Users();
		user.setUserId(1);

		Users user2 = myUserService.getUser(user);
		model.addAttribute("user", user2);

		return JspPage.USERINFO.getPageName();
	}

	 @RequestMapping(value="/userinfo", method=RequestMethod.POST)
	 public String postUserInfo() {
	 log.info(Util.getMethodName() + LogEnum.START.getLogValue());

	 return JspPage.USERINFO.getPageName();
	 }

}