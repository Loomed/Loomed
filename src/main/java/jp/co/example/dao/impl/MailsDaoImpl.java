package jp.co.example.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import enums.LogEnum;
import jp.co.example.dao.MailsDao;
import jp.co.example.entity.Mails;
import jp.co.example.entity.Users;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Repository
public class MailsDaoImpl implements MailsDao {
	private static final String SQL_SELECT_MAILS_WHERE_OPENFLAG = "SELECT count(open_flag) FROM mails WHERE open_flag=true;";
	private static final String SQL_SELECT_FROM_MAILS_WHERE_RECEPTION_USER_ID = "SELECT * FROM mails WHERE reception_user_id = ?;";
	private static final String SQL_INSERT = "INSERT INTO mails (reception_user_id,transmission_user_id	,mail_title	,mail_contents,mail_date,open_flag)VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_MAILS_DELETE = "DELETE FROM mails WHERE mail_id = ?";
	// フラッグ関連
	@Autowired
	JdbcTemplate jt;

	@Override
	public Integer getNewMails(Users user) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return jt.queryForObject(SQL_SELECT_MAILS_WHERE_OPENFLAG, Integer.class);
	}

	// SELECT関連
	@Override
	public List<Mails> findByReUserId(int receptionUserId) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());

		return jt.query(SQL_SELECT_FROM_MAILS_WHERE_RECEPTION_USER_ID, new BeanPropertyRowMapper<Mails>(Mails.class),
				receptionUserId);

	}

	// INSERT関連
	@Override
	public int insert(int receptionUserId, int transmissionUserId, String mailTitle, String mailContents){
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return jt.update(SQL_INSERT,receptionUserId, transmissionUserId, mailTitle, mailContents,
				new Timestamp(new Date().getTime()), false);
	}

	// DELETE関連
	@Override
	public int delete(int mailId) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return jt.update(SQL_MAILS_DELETE, mailId);
	}

}
