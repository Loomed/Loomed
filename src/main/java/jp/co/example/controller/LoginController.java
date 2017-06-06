package jp.co.example.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import enums.ForwardController;
import enums.JspPage;
import enums.LogEnum;
import enums.ScopeKey;
import jp.co.example.entity.Users;
import jp.co.example.form.LoginForm;
import jp.co.example.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

//login.jspへの遷移、ログイン処理を記述
@Slf4j
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@ModelAttribute("loginForm")
	private LoginForm setUpForm() {

		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return new LoginForm();
	}



	//ログアウト処理、loginへ遷移
	@RequestMapping("/logout")
	public String postLogout(SessionStatus sessionStatus) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		sessionStatus.setComplete();

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.LOGIN.getPageName();
	}



	// login.jspへの遷移
	@RequestMapping("/login")
	public String getLogin() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.LOGIN.getPageName();
	}

	// ログイン処理
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(@Valid LoginForm form, BindingResult result, Model model, HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		if (result.hasErrors()) {
			return JspPage.LOGIN.getPageName();
		}

		Users users = loginService.findByIdAndPass(form.getUserId(), form.getPassword());

		if (users != null) {
			// セッションに保存する？

			session.setAttribute(ScopeKey.LOGINUSER.getScopeKey(), users);

			return ForwardController.INDEX.getForwardName();
		}

		model.addAttribute("msg", "IDまたはPASSが間違っています");
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.LOGIN.getPageName();//
	}

}