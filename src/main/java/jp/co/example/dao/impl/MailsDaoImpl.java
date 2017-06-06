package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import enums.LogEnum;
import jp.co.example.dao.MailsDao;
import jp.co.example.entity.Mails;
import jp.co.example.entity.Users;
import lombok.extern.slf4j.Slf4j;
import util.Util;


@Repository
@Slf4j
public class MailsDaoImpl implements MailsDao {
	private static final String SQL_SELECT_MAILS_WHERE_OPENFLAG = "SELECT count(open_flag) FROM mails WHERE open_flag=true AND reception_user_id = ?;";

	@Autowired
	JdbcTemplate jt;
	@Override
	public Mails findByIdAndTitleAndContents(Integer mailID, String mailTitle, String mailContents) {
		return null;

	}

	@Override
	public int getNewMails(Users user) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		int cnt =0;
		cnt = jt.queryForObject("SQL_SELECT_MAILS_WHERE_OPENFLAG", Integer.class);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return cnt;
	}
}

