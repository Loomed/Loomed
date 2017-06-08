package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import enums.JspPage;
import enums.LogEnum;
import enums.ScopeKey;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;
import jp.co.example.service.TrainingConfigService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Controller
@Slf4j
public class TrainingConfigController {
	@Autowired
	TrainingConfigService tcs;

	// home,roothomeから、trainingConfigへの遷移 ／登録の遷移
	@RequestMapping("/trainingConfig")
	public String getTrainingConfig(HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//ログインユーザ受け取り
		Users LoginUser = null;
		LoginUser = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());

		// 研修教室一覧受け取り
		List<Trainings> AllTrainings = tcs.AllTrainings();

		session.setAttribute(ScopeKey.LOGINUSER.getScopeKey(), LoginUser);
		session.setAttribute("AllTrainings", AllTrainings);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.TRAININGCONFIG.getPageName();
	}



	// 削除
	@RequestMapping(value = "/trainingDelete")
	public String getDelete(HttpServletRequest request, HttpSession session,
			@RequestParam int hiddenName) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());


//		String param = request.getParameter("param");
//		System.out.println(param);

		tcs.DelTrainings(hiddenName);



		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return "forward:trainingConfig";
	}

	// 登録
		@RequestMapping(value = "/trainingInsert")
		public String getInsert(HttpServletRequest request, HttpSession session,
				@RequestParam int newPro, @RequestParam String newName, @RequestParam String newInfo) {
			log.info(Util.getMethodName() + LogEnum.START.getLogValue());
			log.info(newPro + ":" + newName+ ":" + newInfo);


//			String param = request.getParameter("param");
//			System.out.println(param);

			tcs.InsTrainings(newPro, newName, newInfo);

			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return "forward:trainingConfig";
		}

}
