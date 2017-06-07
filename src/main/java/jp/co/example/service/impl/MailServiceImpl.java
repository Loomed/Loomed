package jp.co.example.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import jp.co.example.dao.*;
import jp.co.example.entity.*;
import jp.co.example.service.*;

@Service
public class MailServiceImpl implements MailService{
	@Autowired
	private MailsDao mailsDao;

	@Override
	public List<Mails> getMails(Users user) {
		return mailsDao.findByReUserId(user.getUserId());
	}

	@Override
	public int delete(Mails mail) {
		return mailsDao.delete(mail.getMailId());
	}
}