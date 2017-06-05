package jp.co.example.dao.impl;

import org.springframework.stereotype.Repository;

import jp.co.example.dao.MailsDao;
import jp.co.example.entity.Mails;

@Repository
public class MailsDaoImpl implements MailsDao {
	@Override
	Mails findByIdAndTitleAndContents(Integer mailID, String mailTitle, String mailContents) {

	}
}
