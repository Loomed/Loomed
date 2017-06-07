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
public class UserConfigController {

	@Autowired
	private UserConfigService userConfigService;



	//登録//
	@RequestMapping("/userconfig")
	public String getResistration(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<Users> users = userConfigService.getUsers();



		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.USERCONFIG.getPageName();
	}

	//削除
	@RequestMapping(value = "/userdelete")
	public String getDelete() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.USERCONFIG.getPageName();
	}

}
