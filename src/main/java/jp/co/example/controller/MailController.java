package jp.co.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import enums.JspPage;
import enums.LogEnum;
//import jp.co.example.entity.Mails;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Controller
public class MailController {

	// home.jsp、roothome.jspのmailから遷移し、mail.jspへ遷移。
	@RequestMapping(value = "/mail")
	public String getMail() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.MAIL.getPageName();
	}

	// メール処理はサービスに投げる
	// Mails mail = MailService.findByIdAndPass(form.getId(), form.getPass());

	// 送信したらmail.jspへ遷移。
	@RequestMapping(value = "/mail", method = RequestMethod.POST)
	public String postMail() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.MAIL.getPageName();
		// return JspPage.HOME.getPageName();

	}

	// 削除したらmail.jspへ遷移。
	@RequestMapping(value = "/messageDelete")
	public String messageDelete() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.MAIL.getPageName();
	}

	//検索


}
