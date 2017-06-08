package jp.co.example.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import enums.*;
import jp.co.example.dao.*;
import jp.co.example.entity.*;
import jp.co.example.form.*;
import jp.co.example.service.*;
import lombok.extern.slf4j.*;
import util.*;

@Slf4j
@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private MailsDao mailsDao;

	@Autowired
	private UsersDao userDao;

	@Override
	public List<MailsEx> getMails(Users user) {

		List<MailsEx> mails = new ArrayList<>();

		for (Mails mail : mailsDao.findByReUserId(user.getUserId())) {
			MailsEx mailsEx = new MailsEx(mail);
			mailsEx.setTransmissionUserName(userDao.findById(mail.getTransmissionUserId()).getUserName());
			mails.add(mailsEx);
		}

		return mails;
	}

	@Override
	public int delete(Mails mail) {
		return mailsDao.delete(mail.getMailId());
	}

	@Override
	public int insert(MailInsertForm mailInsertForm) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		for (int i = 0; i < mailInsertForm.getReceptionUserIds().length; i++) {
			mailsDao.insert(mailInsertForm.getReceptionUserIds()[i], mailInsertForm.getTransmissionUserId(),
					mailInsertForm.getMailTitle(), mailInsertForm.getMailContents());
		}
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return 0;
	}

	@Override
	public List<List<Users>> getUsersButAuth() {
		List<List<Users>> users = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			users.add(userDao.findAuthUsers(i));
		}

		return users;
	}

	@Override
	public List<MailsEx> getMails() {
		List<MailsEx> mails = new ArrayList<>();

		for (Mails mail : mailsDao.findAllMails()) {
			MailsEx mailsEx = new MailsEx(mail);
			mailsEx.setTransmissionUserName(userDao.findById(mail.getTransmissionUserId()).getUserName());
			mails.add(mailsEx);
		}

		return mails;
	}
}