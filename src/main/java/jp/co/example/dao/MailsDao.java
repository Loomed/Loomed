package jp.co.example.dao;

import jp.co.example.entity.Mails;

public interface MailsDao {
	Mails findByIdAndTitleAndContents(Integer mailID, String mailTitle, String mailContents);
}
