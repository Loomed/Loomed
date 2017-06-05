package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import enums.*;
import jp.co.example.entity.Schedules;
import jp.co.example.entity.Users;
import jp.co.example.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Controller
@Slf4j
public class ScheduleController {
	@Autowired
	ScheduleService ss;

	@RequestMapping("/schedule")
	public String Schedule(HttpSession session, Model model, @RequestParam("date") String date) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(LogEnum.METHOD_PARAM.getLogValue() + date);

		Users user = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());

		//テストデータ
		user = new Users(1, "pass", "山田 太郎", 1, 0);

		//ユーザー情報を確認
		log.info(LogEnum.IF.getLogValue() + "user == null");
		if(user == null) {
			log.info(LogEnum.TRUE.getLogValue());
		} else {
			log.info(LogEnum.FALSE.getLogValue());
		}

		List<Schedules> list = ss.getSchedule(date);
		model.addAttribute(list);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.SCHEDULE.getPageName();
	}
}
