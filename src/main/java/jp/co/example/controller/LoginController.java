package jp.co.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import enums.JspPage;
import enums.LogEnum;
import jp.co.example.entity.Users;
import jp.co.example.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

//login.jspへの遷移を記述
@Slf4j
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	// login.jspからの遷移
	@RequestMapping("/login")
	public String getLogin() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.LOGIN.getPageName();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(@Valid LoginForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "login";
		}

		Users users = loginService.findByIdAndPass(form.getId(), form.getPass());

		if (users != null) {
			model.addAttribute(users);
			return "login";
		}
	}
}