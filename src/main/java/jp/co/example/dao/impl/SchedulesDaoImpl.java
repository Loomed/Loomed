package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import enums.LogEnum;
import jp.co.example.dao.SchedulesDao;
import jp.co.example.entity.Schedules;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Repository
@Slf4j
public class SchedulesDaoImpl implements SchedulesDao{
	private static final String SQL_SELECT_SCHEDULES_WHERE_USERID = "SELECT * FROM schedules WHERE user_id = ?";

	@Autowired
	JdbcTemplate jt;

	@Override
	public List<Schedules> SelectScheduleWhereUserId(Integer userId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<Schedules> list = jt.query(SQL_SELECT_SCHEDULES_WHERE_USERID, new BeanPropertyRowMapper<Schedules>(Schedules.class),
				userId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;
	}

}
