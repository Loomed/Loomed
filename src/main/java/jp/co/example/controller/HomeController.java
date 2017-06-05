package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import enums.JspPage;
import enums.LogEnum;
import enums.ScopeKey;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Controller
public class HomeController {

	/*
	 * @RequestMapping("/home") public String Home(@RequestParam("button")
	 * String button, BindingResult result, Model model) {
	 *
	 * log.info(Util.getMethodName() + LogEnum.START.getLogValue());
	 *
	 *
	 * if (result.hasErrors()) { return JspPage.LOGIN.getPageName(); } if
	 * ("userinfo".equals(button)) { return JspPage.USERINFO.getPageName(); }
	 * else if ("member".equals(button)) { return JspPage.MEMBER.getPageName();
	 * } else if ("sharaconfig".equals(button)) { return
	 * JspPage.SHARECONFIG.getPageName(); } log.info(Util.getMethodName() +
	 * LogEnum.END.getLogValue()); return null; }
	 */
	@RequestMapping("/home")
	public String getHome(HttpSession session,@RequestParam("button") String button, BindingResult result, Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		/*if (result.hasErrors()) {
			return JspPage.LOGIN.getPageName();
		}*/
		Users user = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());
		Trainings tr = (Trainings) session.getAttribute(ScopeKey.LOGINROOM.getScopeKey());
		//テストデータ
		user = new Users(1, "pass", "山田 太郎", 1, 0);
		tr = new Trainings(2,"Java研修",2,"未経験者向けのJava研修");
		System.out.println(button);
		//ボタンで遷移先を決定
		/*if ("userinfo".equals(button)) {
			return JspPage.USERINFO.getPageName();
		} else if ("member".equals(button)) {
			return JspPage.MEMBER.getPageName();
		} else if ("shareconfig".equals(button)) {
			return JspPage.SHARECONFIG.getPageName();
		}*/
		model.addAttribute(user);
		model.addAttribute(tr);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.HOME.getPageName();
	}

}