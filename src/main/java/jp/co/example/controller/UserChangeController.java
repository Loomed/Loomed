package jp.co.example.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import enums.*;
import jp.co.example.entity.*;
import jp.co.example.service.*;
import lombok.extern.slf4j.*;
import util.*;

@Slf4j
@Controller
public class UserChangeController {

	@Autowired
	private UserChangeService userChangeService;

	@Autowired
	private UserInfoService userInfoService;

	/**
	* userchangeへの遷移
	* 2017/06/05
	* @Author sakata
	*/
	@RequestMapping("/userchange")
	public String getUserChange(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//本来ならセッションのユーザ値を使用する
		Users user = new Users();
		user.setUserId(9);
		UsersEx user2 = userInfoService.getUser(user);

		model.addAttribute("user", user2);

		//##テスト用処理

		List<Trainings> trainigs = userChangeService.getTrainig();
		List<Companies> companies= userChangeService.getCompanies();

		model.addAttribute("rooms", trainigs);
		model.addAttribute("companies", companies);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());

		return JspPage.USERCHANGE.getPageName();
	}
}