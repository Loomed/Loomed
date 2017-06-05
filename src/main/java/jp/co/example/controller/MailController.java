package jp.co.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import enums.JspPage;
import enums.LogEnum;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import util.Util;

//home、roothomeからのmail.jspの遷移を記述
@Getter
@Slf4j

public class MailController {

	//home.jsp、roothome.jspのmailから遷移
	@RequestMapping(value = "/mail")
	public String getMail() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//メール処理はサービスに投げる

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.MAIL.getPageName();

		}

}

