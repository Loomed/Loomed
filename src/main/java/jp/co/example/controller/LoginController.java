package jp.co.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import enums.JspPage;
import enums.LogEnum;
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
		return new LoginForm();
	}

	// ログアウト処理
	if

	// login.jspからの遷移
	@RequestMapping("/login")
	public String getLogin() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.LOGIN.getPageName();
	}

	// ログイン処理
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(@Valid LoginForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return JspPage.LOGIN.getPageName();
		}

		Users users = loginService.findByIdAndPass(form.getId(), form.getPass());

		if (users != null) {
			model.addAttribute(users);
			return JspPage.INDEX.getPageName();
		}

		model.addAttribute("msg", "IDまたはPASSが間違っています");
		return JspPage.LOGIN.getPageName();
	}

}