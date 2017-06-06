package jp.co.example.dao;

import jp.co.example.entity.Mails;
import jp.co.example.entity.Users;

public interface MailsDao {
	Mails findByIdAndTitleAndContents(Integer mailID, String mailTitle, String mailContents);

	Integer getNewMails(Users user);

}
