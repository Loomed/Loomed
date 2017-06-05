package jp.co.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;

//home、roothomeからの遷移を記述
@Getter
public class MailController {

	//home.jspのmailから遷移
	@RequestMapping(value = "/mail")
	public String postLogin() {
			return "mail";
		}

}

