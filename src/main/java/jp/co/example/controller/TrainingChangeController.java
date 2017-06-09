package jp.co.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import enums.*;
import jp.co.example.entity.Trainings;
import jp.co.example.service.Generalized;
import jp.co.example.service.TrainingChangeService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Controller
@Slf4j
public class TrainingChangeController {

	@Autowired
	TrainingChangeService tcs;

	@RequestMapping("/trainingChange")
	public String getTrainingChange(HttpServletRequest request, HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		String str_id = request.getParameter("page");
		int id = 0;
		if(Generalized.isNum(str_id)){
			id=Integer.parseInt(str_id);
		}else{
			id=0;
		}

		//ログインユーザ受け取り
		Trainings LookRoom = null;
		LookRoom = tcs.OneRoom(id);
/*
		// 研修教室一覧受け取り
		List<Trainings> AllTrainings = tcs.AllTrainings();

		session.setAttribute(ScopeKey.LOGINUSER.getScopeKey(), LoginUser);
		session.setAttribute("AllTrainings", AllTrainings);
*/

		session.setAttribute("LookRoom", LookRoom);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.TRAININGCHANGE.getPageName();
	}

	@RequestMapping("/trainingChangeInsert")
	public String getTrainingChangeInsert(HttpServletRequest request, HttpSession session,@RequestParam String newPro, @RequestParam String roomName,@RequestParam String newInfo) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		session.getAttribute("LookRoom");
		int tes = ((Trainings)session.getAttribute("LookRoom")).getTrainingId();

		log.info(newPro + ":" + roomName+ ":" + newInfo+ ":" + tes);

		tcs.UpdTrainings(tes, roomName, Integer.valueOf(newPro), newInfo);
/*
		// 研修教室一覧受け取り
		List<Trainings> AllTrainings = tcs.AllTrainings();

		session.setAttribute(ScopeKey.LOGINUSER.getScopeKey(), LoginUser);
		session.setAttribute("AllTrainings", AllTrainings);
*/


		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return RedirectController.TRAININGCONFIG.getRedirectName();
	}
}
