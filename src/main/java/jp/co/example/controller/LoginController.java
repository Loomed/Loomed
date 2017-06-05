package jp.co.example.controller;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import enums.*;
import jp.co.example.entity.*;
import jp.co.example.form.*;
import jp.co.example.service.*;
import lombok.extern.slf4j.*;
import util.*;

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