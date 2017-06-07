package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.MailsDao;
import jp.co.example.entity.Mails;
import jp.co.example.entity.Users;
import jp.co.example.service.MailService;

@Service
public class MailServiceImpl implements MailService{
	@Autowired
	private MailsDao MailsDao;

	@Override
	public List<Mails> getMails(Users user) {
		return MailsDao.findByReUserId(user.getUserId());
	}
}