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
public class UserConfigController {

	@Autowired
	private UserConfigService userConfigService;

	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping("/userconfig")
	public String getUserConfig(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		this.init(model);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.USERCONFIG.getPageName();
	}

	@RequestMapping(value = "/userconfig", method = RequestMethod.POST)
	public String postUserConfig(UserDeleteForm userDeleteForm, UserConfigForm userConfigForm, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		if (userConfigForm.getUserName() != null) {
			log.info("insert");
			Maps[] maps = null;

			if (!userInfoService.getComapnies(userConfigForm.getCompanyName()).isEmpty()) {
				userConfigForm.setCompanyId(
						userInfoService.getComapnies(userConfigForm.getCompanyName()).get(0).getCompanyId());
			}

			if (userConfigForm.getTrainingId().length > 0) {
				maps = new Maps[userConfigForm.getTrainingId().length];

				for (int i = 0; i < maps.length; i++) {
					maps[i] = new Maps(null, userConfigForm.getTrainingId()[i]);
				}
			}

			userConfigService.insert(userConfigForm, maps);
		} else if (userDeleteForm.getUserId() != null) {
			log.info("delete");
			userConfigService.delete(userDeleteForm);
		}

		this.init(model);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.USERCONFIG.getPageName();
	}

	private void init(Model model) {
		List<UsersEx> users = userConfigService.getUser();
		List<Companies> companies = userConfigService.getCompanies();
		List<Trainings> trainigs = userConfigService.getTrainig();

		model.addAttribute("companies", companies);
		model.addAttribute("rooms", trainigs);
		model.addAttribute("users", users);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
	}
}
