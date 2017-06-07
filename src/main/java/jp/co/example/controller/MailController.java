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

		// 本来はセッションからログイン値を取得する
		Users user = new Users();
		user.setUserId(1);

		model.addAttribute(ScopeKey.LOGINUSER.getScopeKey(), user);
		// 終わり

		List<MailsEx> mails = mailService.getMails(user);

		model.addAttribute("mails", mails);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.MAIL.getPageName();
	}

	@RequestMapping(value = "/mail", method = RequestMethod.POST)
	public String postMail(MailDeleteForm mailDeleteForm, MailInsertForm mailInsertForm) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info("delete");
		//mailService.delete(mailDeleteForm);

		log.info("insert");
		log.info("insert myid : " + mailInsertForm.getTransmissionUserId());
		log.info("insert ids  : " + mailInsertForm.getReceptionUserIds().length);
		log.info("insert title: " + mailInsertForm.getMailTitle());
		log.info("insert ctxt : " + mailInsertForm.getMailContents());

		mailService.insert(mailInsertForm);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.MAIL.getPageName();
	}
}
