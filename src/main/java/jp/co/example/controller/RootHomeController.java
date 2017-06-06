package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
import enums.LogEnum;
import jp.co.example.entity.Schedules;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;
import jp.co.example.service.RootHomeService;
import lombok.extern.slf4j.Slf4j;
import util.Util;
@Slf4j
@Controller
public class RootHomeController {
	@Autowired
	private RootHomeService RHS;

	@RequestMapping(value = "/roothome")
	public String Home(HttpSession session, HttpServletRequest reques, Model model) {

		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		// セッションの受け取りと必要なデータ生成
		// Users user =
		// (Users)session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());
		Trainings tr = new Trainings();
		String cnt = null;
		String maps = null;
		Integer tid = 0;
		String url = null;
		int index = 0;
		String id = null;
		int training_id = 0;
		List<Schedules> list = new ArrayList<Schedules>();
		//データに色々格納中
		try {
			url = reques.getRequestURI();
			index = url.lastIndexOf("=");
			id = url.substring(index);

			if (id != null) {
				training_id = Integer.parseInt(id);
			}
			tr = RHS.getTrainingName(training_id);
			session.setAttribute("tr", tr);
		} catch (Exception e) {

		}

		// テストデータ
		Users user = new Users(1, "pass", "山田 太郎", 1, 0);
		// サービスへ
		maps = RHS.getTrainingid(user);
		cnt = RHS.getNewMails(user);
		list = RHS.getInpoSche();
		//tr = RHS.getTrainingName(training_id);
		//メールの新着無しを処理してます
		if (cnt.equals("0")) {
			cnt = "新着無し";
		}
		//基本セッションとかはここ
		session.setAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("cnt", cnt);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.ROOTHOME.getPageName();
	}

}
