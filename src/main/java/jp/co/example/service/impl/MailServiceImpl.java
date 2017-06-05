package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.MailsDao;
import jp.co.example.entity.Mails;
import jp.co.example.service.MailService;

@Service
public class MailServiceImpl implements MailService{
	@Autowired
	private MailsDao MailsDao;

	@Override
	public Mails findByIdAndTitleAndContents(Integer mailID, String mailTitle, String mailContents) {
		return MailsDao.findByIdAndTitleAndContents(mailID, mailTitle, mailContents);
	}
}