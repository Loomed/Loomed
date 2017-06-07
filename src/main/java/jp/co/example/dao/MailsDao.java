package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Mails;
import jp.co.example.entity.Users;

public interface MailsDao {
	List<Mails> findByReUserId(int receptionUserId);

	Integer getNewMails(Users user);

	int delete(int mailId);

	int insert(int receptionUserId, int transmissionUserId, String mailTitle, String mailContents);
}
