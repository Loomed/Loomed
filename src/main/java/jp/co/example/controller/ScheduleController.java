package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import enums.JspPage;
import enums.LogEnum;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Controller
@Slf4j
public class ScheduleController {

	@RequestMapping("/schedule")
	public String Schedule(@RequestParam("date") String date) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info(LogEnum.METHOD_PARAM.getLogValue() + date);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.SCHEDULE.getPageName();
	}
}
