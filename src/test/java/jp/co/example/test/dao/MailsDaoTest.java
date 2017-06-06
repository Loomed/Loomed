package jp.co.example.test.dao;

import jp.co.example.entity.Mails;
import jp.co.example.entity.Users;

public interface MailsDaoTest {
	Mails findByIdAndTitleAndContents(Integer mailID, String mailTitle, String mailContents);

	Integer getNewMails(Users user);

}
