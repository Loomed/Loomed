package jp.co.example.controller;

import java.util.*;

import javax.servlet.http.*;

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
	private MailDeleteForm setUpForm() {
		return new MailDeleteForm();
	}

	@RequestMapping(value = "/mail")
	public String getMail(Model model, HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Users user = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());

		List<MailsEx> mails = mailService.getMails(user);

		model.addAttribute("mails", mails);

		this.init(model);
		model.addAttribute("flag", false);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.MAIL.getPageName();
	}

	@RequestMapping(value = "/mail", method = RequestMethod.POST)
	public String postMail(MailCheckForm mailCheck, MailDeleteForm mailDeleteForm, MailInsertForm mailInsertForm, WatchForm watchForm,
			Model model, HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Users user = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());

		List<MailsEx> mails = new ArrayList<>();

		if(mailCheck.getMailId() != null)
		{
			mailService.openMail(mailCheck.getMailId());
		}

		if (mailDeleteForm.getMailId() != null) {
			mailService.delete(mailDeleteForm);
		} else if (mailInsertForm.getTransmissionUserId() != null) {
			mailService.insert(mailInsertForm);
		}

		if (!watchForm.isAllMail()) {
			mails = mailService.getMails(user);
		} else {
			mails = mailService.getMails();
		}
		model.addAttribute("flag", watchForm.isAllMail());

		this.init(model);

		model.addAttribute("mails", mails);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.MAIL.getPageName();
	}

	private void init(Model model) {

		List<List<Users>> users = mailService.getUsersButAuth();

		log.info(" ルート : " + users.get(0).size());
		log.info(" 講師　 : " + users.get(1).size());
		log.info(" 担当者 : " + users.get(2).size());
		log.info(" 研修生 : " + users.get(3).size());

		model.addAttribute("auth0", users.get(0));
		model.addAttribute("auth1", users.get(1));
		model.addAttribute("auth2", users.get(2));
		model.addAttribute("auth3", users.get(3));

	}
}
