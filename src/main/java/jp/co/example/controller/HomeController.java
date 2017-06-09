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
import enums.ScopeKey;
import jp.co.example.entity.Schedules;
import jp.co.example.entity.Shares;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;
import jp.co.example.service.HomeService;
import jp.co.example.service.ShareService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Controller
public class HomeController {
	@Autowired
	private HomeService HS;
	@Autowired
	private ShareService SS;

	@RequestMapping(value = "/home")
	public String Home(HttpSession session, HttpServletRequest reques, Model model) {

		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		// セッションの受け取りと必要なデータ生成
		Users user =(Users)session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());
		Trainings tr = null;
		String cnt = null;
		String id = reques.getParameter("page");
		int training_id = 0;
		List<Shares> sl = new ArrayList<Shares>();
		List<Schedules> list = new ArrayList<Schedules>();
		//データに色々格納中

			training_id = Integer.parseInt(id);
			tr = HS.getTrainingName(training_id);
			sl = SS.selectvisiblelist(tr.getTrainingId());
			session.setAttribute(ScopeKey.LOGINROOM.getScopeKey(), tr);
			HS.setOutPutStream(sl);
		// サービスへ
		cnt = HS.getNewMails(user);
		list = HS.getInpoSche(user);
		//tr = HS.getTrainingName(training_id);
		//メールの新着無しを処理してます
		if (cnt.equals("0")) {
			cnt = "新着無し";
		}
		//基本セッションとかはここ
		model.addAttribute("sl",sl);
		session.setAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("cnt", cnt);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.HOME.getPageName();
	}

}