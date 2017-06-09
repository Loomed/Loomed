package jp.co.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.*;
import jp.co.example.entity.*;
import jp.co.example.service.*;
import lombok.extern.slf4j.Slf4j;
import util.Util;
@Slf4j
@Controller
public class RootHomeController {
	@Autowired
	private HomeService HS;
	@Autowired
	private RootHomeService RHS;
	@Autowired
	private ShareService SS;

	@RequestMapping(value = "/roothome")
	public String Home(HttpSession session, HttpServletRequest reques, Model model) {

		// セッションの受け取りと必要なデータ生成
		Users user =(Users)session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());
		String cnt = null;
		List<Schedules> list = new ArrayList<Schedules>();
		List<Shares> sl = new ArrayList<Shares>();
		//データに色々格納中
		// サービスへ
		sl = SS.selectlist(1);
		cnt = RHS.getNewMails(user);
		list = RHS.getInpoSche(user);
		//tr = HS.getTrainingName(training_id);
		//メールの新着無しを処理してます
		if (cnt.equals("0")) {
			cnt = "新着無し";
		}
		//基本セッションとかはここ
		model.addAttribute("sl",sl);
		session.setAttribute("user", user);
		session.setAttribute(ScopeKey.LOGINROOM.getScopeKey(), HS.getTrainingName(1));
		model.addAttribute("list", list);
		model.addAttribute("cnt", cnt);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.ROOTHOME.getPageName();
	}

}
