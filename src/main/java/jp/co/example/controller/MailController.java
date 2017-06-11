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

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private UserChangeService userChangeService;

	@ModelAttribute("deleteForm")
	private MailDeleteForm setUpForm() {
		return new MailDeleteForm();
	}

	@RequestMapping(value = "/mail")
	public String getMail(Model model, HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Users user = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());

		UsersEx userEx = userInfoService.getUser(user);

		List<MailsEx> mails = mailService.getMails(user);

		model.addAttribute("mails", mails);
		model.addAttribute("flag", false);
		this.init(model, userEx);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.MAIL.getPageName();
	}

	@RequestMapping(value = "/mail", method = RequestMethod.POST)
	public String postMail(MailCheckForm mailCheck, MailDeleteForm mailDeleteForm, MailInsertForm mailInsertForm,
			WatchForm watchForm, Model model, HttpSession session) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Users user = (Users) session.getAttribute(ScopeKey.LOGINUSER.getScopeKey());

		UsersEx userEx = userInfoService.getUser(user);

		List<MailsEx> mails = new ArrayList<>();

		if (mailCheck.getMailId() != null) {
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

		this.init(model, userEx);

		model.addAttribute("mails", mails);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return JspPage.MAIL.getPageName();
	}

	private void init(Model model, UsersEx user) {
		log.info("katukatu + " + user.getAuthority());
		List<List<Users>> users = mailService.getUsersButAuth();

		List<Users> auth0 = users.get(0);
		List<Users> auth1 = users.get(1);
		List<Users> auth2 = users.get(2);
		List<Users> auth3 = users.get(3);

		if (user.getAuthority() <= 1) {
			model.addAttribute("auth0", users.get(0));
			model.addAttribute("auth1", users.get(1));
			model.addAttribute("auth2", users.get(2));
			model.addAttribute("auth3", users.get(3));
		} else {

			if (user.getAuthority() == 2) {

				List<Users> newAuth1 = new ArrayList<>();
				for (int i = 0; i < auth1.size(); i++) {

					List<Maps> mp = userChangeService.getMaps(auth1.get(i));

					log.info("PARAM 1-------> " + auth1.get(i).getUserId());
					log.info("PARAM 2-------> " + mp.size());
					for (int k = 0; k < mp.size(); k++) {

						for (int j = 0; j < user.getTrainings().size(); j++) {
							log.info("PARAM-------> " + user.getTrainings().get(j).getTrainingId()
									+ mp.get(k).getTrainingId());
							// 自身（担当者）と研修IDが等しい講師
							if (user.getTrainings().get(j).getTrainingId() == mp.get(k).getTrainingId()) {

								newAuth1.add(auth2.get(i));

							}
						}
					}
				}

				List<Users> newAuth2 = new ArrayList<>();
				List<Users> newAuth3 = new ArrayList<>();
				for (int i = 0; i < auth2.size(); i++) {
					// 自身（担当者）と研修IDが等しい担当者

					if (auth2.get(i).getCompanyId() == user.getCompanyId()) {
						newAuth2.add(auth2.get(i));
					}
				}

				for (int i = 0; i < auth3.size(); i++) {
					// 自身（担当者）と研修IDが等しい研修生
					if (auth3.get(i).getCompanyId() == user.getCompanyId()) {
						newAuth3.add(auth3.get(i));
					}
				}

				auth0 = new ArrayList<>();
				auth1 = newAuth1;
				auth2 = newAuth2;
				auth3 = newAuth3;

			} else if (user.getAuthority() == 3) {

				/* 研修生 */

				List<Users> newAuth1 = new ArrayList<>();
				for (int i = 0; i < auth1.size(); i++) {

					List<Maps> mp = userChangeService.getMaps(auth1.get(i));

					log.info("PARAM 1-------> " + auth1.get(i).getUserId());
					log.info("PARAM 2-------> " + mp.size());
					for (int k = 0; k < mp.size(); k++) {

						for (int j = 0; j < user.getTrainings().size(); j++) {
							log.info("PARAM-------> " + user.getTrainings().get(j).getTrainingId()
									+ mp.get(k).getTrainingId());
							// 自身（担当者）と研修IDが等しい講師
							if (user.getTrainings().get(j).getTrainingId() == mp.get(k).getTrainingId()) {

								newAuth1.add(auth2.get(i));

							}
						}
					}
				}

				List<Users> newAuth2 = new ArrayList<>();
				List<Users> newAuth3 = new ArrayList<>();
				for (int i = 0; i < auth2.size(); i++) {
					// 自身（担当者）と企業IDが等しい担当者

					if (auth2.get(i).getCompanyId() == user.getCompanyId()) {
						newAuth2.add(auth2.get(i));
					}
				}

				for (int i = 0; i < auth3.size(); i++) {
					// 自身（研修生）と研修IDが等しい研修生

					if (auth3.get(i).getCompanyId() == user.getCompanyId()) {
						newAuth3.add(auth3.get(i));
					} else {
						List<Maps> mp = userChangeService.getMaps(auth3.get(i));

						for (int k = 0; k < mp.size(); k++) {

							for (int j = 0; j < user.getTrainings().size(); j++) {
								log.info("PARAM-------> " + user.getTrainings().get(j).getTrainingId()
										+ mp.get(k).getTrainingId());
								// 自身（研修生）と研修IDが等しい研修生
								if (user.getTrainings().get(j).getTrainingId() == mp.get(k).getTrainingId()) {

									newAuth3.add(auth3.get(i));

								}
							}
						}
					}
				}

				auth0 = new ArrayList<>();
				auth1 = newAuth1;
				auth2 = newAuth2;
				auth3 = newAuth3;
			}
		}

		model.addAttribute("auth0", auth0);
		model.addAttribute("auth1", auth1);
		model.addAttribute("auth2", auth2);
		model.addAttribute("auth3", auth3);

	}
}
