package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
import enums.LogEnum;
import lombok.extern.slf4j.Slf4j;
import util.Util;

//home・roothomeからの遷移を記述
@Slf4j
@Controller
public class ShareconfigController {

	//home・roothomeからの遷移
	@RequestMapping("/shareconfig")
	public String getShare() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.SHARECONFIG.getPageName();
	}



}