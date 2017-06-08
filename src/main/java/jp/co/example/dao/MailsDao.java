package jp.co.example.dao;

import java.util.*;

import jp.co.example.entity.*;

public interface MailsDao {
	List<Mails> findByReUserId(int receptionUserId);

	List<Mails> findAllMails();

	Integer getNewMails(Users user);

	int delete(int mailId);

	int insert(int receptionUserId, int transmissionUserId, String mailTitle, String mailContents);
}
