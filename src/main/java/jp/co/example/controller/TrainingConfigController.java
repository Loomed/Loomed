package jp.co.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
import enums.LogEnum;
import jp.co.example.service.TrainingConfigService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Controller
@Slf4j
public class TrainingConfigController {
	@Autowired
	TrainingConfigService tcs;

	@RequestMapping("/trainingConfig")
	public String trainingConfig() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());



		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.TRAININGCONFIG.getPageName();
	}
}
