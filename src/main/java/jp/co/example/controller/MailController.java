package jp.co.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;

//home、roothomeからのmail.jspの遷移を記述
@Getter
public class MailController {

	//home.jsp、roothome.jspのmailから遷移
	@RequestMapping(value = "/mail")
	public String getMail() {
		return "mail";

		}

}

