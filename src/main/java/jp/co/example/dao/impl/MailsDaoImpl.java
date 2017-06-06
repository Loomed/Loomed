package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.MailsDao;
import jp.co.example.entity.Mails;
import jp.co.example.entity.Users;

@Repository
public class MailsDaoImpl implements MailsDao {
	private static final String SQL_SELECT_MAILS_WHERE_OPENFLAG = "SELECT count(open_flag) FROM mails WHERE open_flag=true;";

	@Autowired
	JdbcTemplate jt;
	@Override
	public Mails findByIdAndTitleAndContents(Integer mailID, String mailTitle, String mailContents) {
		return null;


	}

	@Override
	public int getNewMails(Users user) {
		int cnt =0;
		return cnt;
	}
}

