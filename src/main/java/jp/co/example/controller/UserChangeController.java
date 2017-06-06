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
	private UserInfoService userInfoSerice;

	/**
	* userchangeへの遷移
	* 2017/06/05
	* @Author sakata
	*/
	@RequestMapping("/userchange")
	public String getUserChange(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


		List<Trainings> trainigs = userInfoSerice.getTrainig();
		model.addAttribute("rooms", trainigs);
		log.info(trainigs.get(0).getTrainingName());

		return JspPage.USERCHANGE.getPageName();
	}
}