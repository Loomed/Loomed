package jp.co.example.controller;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import enums.*;
import lombok.extern.slf4j.*;
import util.*;

@Slf4j
@Controller
public class UserChangeController {

	/**
	* userchangeへの遷移
	* 2017/06/05
	* @Author sakata
	*/
	@RequestMapping("/userchange")
	public String getUserChange() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		return JspPage.USERCHANGE.getPageName();
	}
}