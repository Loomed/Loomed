package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String getLogin() {
		return "login";
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String postLogin(@Valid Model model) {
//		return "login";
//	}
}