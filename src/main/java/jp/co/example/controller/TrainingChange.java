package jp.co.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
import enums.LogEnum;
import jp.co.example.entity.Trainings;
import jp.co.example.service.TrainingChangeService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Controller
@Slf4j
public class TrainingChange {

	@Autowired
	TrainingChangeService tcs;

	@RequestMapping("/trainingChange")
	public String getTrainingConfig(HttpServletRequest request, HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//ログインユーザ受け取り
		Trainings LookRoom = null;
/*
		// 研修教室一覧受け取り
		List<Trainings> AllTrainings = tcs.AllTrainings();

		session.setAttribute(ScopeKey.LOGINUSER.getScopeKey(), LoginUser);
		session.setAttribute("AllTrainings", AllTrainings);
*/
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.TRAININGCONFIG.getPageName();
	}
}
