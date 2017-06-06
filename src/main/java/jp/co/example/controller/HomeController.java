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
import jp.co.example.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Controller
public class HomeController {
	@Autowired
	private HomeService HS;

	@RequestMapping(value = "/home")
	public String Home(HttpSession session, HttpServletRequest reques, Model model) {

		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//セッションの受け取りと必要なデータ生成
		//Users user = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());
		Trainings tr = new Trainings();
		String cnt = null;
		//Maps maps =0;
		List<Schedules> list = new ArrayList<Schedules>();
		// テストデータ
		Users user = new Users(10, "test", "稲田 泳助", 2, 3);
		//サービスへ
		System.out.println(user);
		//maps = HS.getTrainingid(user);
		cnt = HS.getNewMails(user);
		list = HS.getInpoSche();
		//tr = HS.getTrainingName();

		if(cnt.equals("0")){
			cnt ="新着無し";
		}
		// ボタンで遷移先を決定
		/*
		 * if ("userinfo".equals(button)) { return
		JspPage.USERINFO.getPageName();
		  } else if ("member".equa
		 * ("shareconfig".equals(button)) { return
		 * JspPage.SHARECONFIG.getPagls(button)) {
		 * return JspPage.MEMBER.getPageName(); } else ifeName(); }
		 */
		session.setAttribute("tr", tr);
		session.setAttribute("user", user);
		model.addAttribute("list",list);
		model.addAttribute("cnt",cnt);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.HOME.getPageName();
	}

	/*@RequestMapping("/home")
	public String getHome() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.HOME.getPageName();
	}*/

}