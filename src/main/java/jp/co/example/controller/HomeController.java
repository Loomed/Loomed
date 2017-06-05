package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
import lombok.Getter;



//homeから各ページへの遷移を記述
@Getter
@Controller
public class HomeController {

	@RequestMapping(value = "/home")
	public String postLogin(Model model) {
		return JspPage.HOME.getPageName();

	}

}
