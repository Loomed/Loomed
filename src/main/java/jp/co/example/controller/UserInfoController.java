package jp.co.example.controller;

import javax.servlet.http.*;
import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import enums.*;
import jp.co.example.entity.*;
import jp.co.example.form.*;
import jp.co.example.service.*;
import lombok.extern.slf4j.*;
import util.*;

@Slf4j
@Controller
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@ModelAttribute("userChangeForm")
	private UserChangeForm setUpForm() {
		return new UserChangeForm();
	}

	/**
	 * userinfoへの遷移 2017/06/05
	 *
	 * @Author sakata
	 */
	@RequestMapping("/userinfo")
	public String getUserInfo(Model model) { // 引数の
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		// テスト用処理
		// 本来ならセッションのユーザ値を使用する
		Users user = new Users();
		user.setUserId(5);
		UsersEx user2 = userInfoService.getUser(user);

		model.addAttribute("user", user2);

		// ##テスト用処理

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.USERINFO.getPageName();
	}

	/**
	 * userinfoへの遷移 2017/06/05 userchangeから遷移
	 *
	 * @Author sakata
	 */
	@RequestMapping(value = "/userinfo", method = RequestMethod.POST)
	public String postUserInfo(@Valid UserChangeForm userChangeForm, Model model, HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		// ログ表示
		getUserLog(userChangeForm);

		Users auth = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());

		// 作成ミス 本来ならサービス層で行う処理
		Maps[] maps = null;
		if (auth.getAuthority() <= 1) {
			if (!userInfoService.getComapnies(userChangeForm.getCompanyName()).isEmpty()) {
				userChangeForm.setCompanyId(
						userInfoService.getComapnies(userChangeForm.getCompanyName()).get(0).getCompanyId());
			}
			maps = new Maps[userChangeForm.getTrainingId().length];
			for (int i = 0; i < maps.length; i++) {
				maps[i] = new Maps(userChangeForm.getUserId(), userChangeForm.getTrainingId()[i]);
			}
		}

		userInfoService.update(auth, userChangeForm, maps);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.USERINFO.getPageName();
	}

	private void getUserLog(UserChangeForm user) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info("user userId   : " + user.getUserId());
		log.info("user password : " + user.getPassword());
		log.info("user userName : " + user.getUserName());
		log.info("user authority: " + user.getAuthority());
		log.info("user companyId: " + user.getCompanyId());
		log.info("user companyName: " + user.getCompanyName());
		log.info("user trainingId : " + user.getTrainingId().length);

	}

}