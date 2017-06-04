package jp.co.example.controller;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;

//home、roothomeからの遷移を記述
@Getter
public class MailController {

	@RequestMapping(value = "/home")//コピペして少し弄っただけの状態。
	public String postLogin(@Valid LoginForm form, BindingResult result, Model model) {
		if (result.hasErrors())
		{
			return "home";
		}

}
	}
