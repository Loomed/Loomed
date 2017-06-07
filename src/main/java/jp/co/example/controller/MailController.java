package jp.co.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import enums.JspPage;
import enums.LogEnum;
import jp.co.example.entity.Mails;
import jp.co.example.entity.Users;
import jp.co.example.service.MailService;
//import jp.co.example.entity.Mails;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Controller
public class MailController {
@Autowired
private MailService mailService;
	// home.jsp、roothome.jspのmailから遷移し、mail.jspへ遷移。
	@RequestMapping(value = "/mail")
	public String getMail(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//本来はセッションから値を取得する
		Users user = new Users();
		user.setUserId(1);

		List<Mails> mails  = mailService.getMails(user);

		model.addAttribute("mails", mails);

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
