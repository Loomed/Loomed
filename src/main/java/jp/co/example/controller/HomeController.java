package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Getter;



//homeから各ページへの遷移を記述
@Getter
@Controller
public class HomeController {

	@RequestMapping(value = "/home")
	public String postLogin(@RequestParam("data") String data,@RequestParam("button") String button,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "login";
		}
		if("".equals(button)){
			return "member";
		}
		return "userinfo";

	}

}
