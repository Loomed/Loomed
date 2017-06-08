package jp.co.example.dao.impl;

import java.sql.*;
import java.util.*;
import java.util.Date;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import enums.*;
import jp.co.example.dao.*;
import jp.co.example.entity.*;
import lombok.extern.slf4j.*;
import util.*;

@Slf4j
@Repository
public class MailsDaoImpl implements MailsDao {
	private static final String SQL_SELECT_MAILS_WHERE_OPENFLAG = "SELECT count(open_flag) FROM mails WHERE open_flag=true;";
	private static final String SQL_SELECT_FROM_MAILS_WHERE_RECEPTION_USER_ID = "SELECT * FROM mails WHERE reception_user_id = ?;";
	private static final String SQL_INSERT = "INSERT INTO mails (reception_user_id,transmission_user_id	,mail_title	,mail_contents,mail_date,open_flag)VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_MAILS_DELETE = "DELETE FROM mails WHERE mail_id = ?";
	private static final String SQL_SELECT_MAILS = "SELECT * FROM mails";
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

	@Override
	public List<Mails> findAllMails() {
		return jt.query(SQL_SELECT_MAILS, new BeanPropertyRowMapper<Mails>(Mails.class));
	}

}
