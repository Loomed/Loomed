package jp.co.example.controller;

import java.util.*;

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
	public String getUserChange(UserForm user, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		UsersEx userEx = userInfoService.getUser(user);

		List<Trainings> trainigs = userChangeService.getTrainig();
		List<Companies> companies= userChangeService.getCompanies();
		List<Maps> maps = userChangeService.getMaps(user);

		List<Integer> myMaps = new ArrayList();
		for(Maps map : maps)
		{
			myMaps.add(map.getTrainingId());
		}

		model.addAttribute("rooms", trainigs);
		model.addAttribute("companies", companies);
		model.addAttribute("maps", myMaps);
		model.addAttribute("user", userEx);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());

		return JspPage.USERCHANGE.getPageName();
	}
}