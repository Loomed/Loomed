package jp.co.example.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import enums.*;
import jp.co.example.entity.*;
import jp.co.example.form.*;
import jp.co.example.service.*;
//import jp.co.example.entity.Mails;
import lombok.extern.slf4j.*;
import util.*;

@Slf4j
@Controller
public class MailController {

	@Autowired
	private MailService mailService;

	@ModelAttribute("deleteForm")
	private MailDeleteForm setUpForm(){
		return new MailDeleteForm();
	}

	@RequestMapping(value = "/mail")
	public String getMail(Model model) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		// 本来はセッションから値を取得する
		Users user = new Users();
		user.setUserId(1);
		// 終わり

		List<Mails> mails = mailService.getMails(user);

		model.addAttribute("mails", mails);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.MAIL.getPageName();
	}

	// 送信したらmail.jspへ遷移。
	@RequestMapping(value = "/mail", method = RequestMethod.POST)
	public String postMail(MailDeleteForm mailDeleteForm) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info("delete");
		mailService.delete(mailDeleteForm);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.MAIL.getPageName();
	}
}
