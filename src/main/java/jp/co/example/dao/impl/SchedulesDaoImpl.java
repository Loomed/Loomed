package jp.co.example.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import enums.LogEnum;
import jp.co.example.dao.SchedulesDao;
import jp.co.example.entity.Schedules;
import jp.co.example.entity.Users;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Repository
@Slf4j
public class SchedulesDaoImpl implements SchedulesDao {

	private static final String SQL_SELECT_SCHEDULES_WHERE_USERID_AND_DATE =
			"SELECT * FROM schedules WHERE user_id = ? AND upload_datetime BETWEEN ? AND ? ORDER BY upload_datetime";
	private static final String SQL_SELECT_SCHEDULES_WHERE_IMPORTANT =
			"SELECT * FROM schedules WHERE important = true AND user_id = ? ORDER BY upload_datetime ";
	private static final String SQL_UPDATE_WHERE_SCHEDULEID =
			"UPDATE schedules SET schedule_contents = ?, upload_datetime = ?, important = ? WHERE schedule_id = ?";
	private static final String SQL_DELETE_WHERE_SCHEDULEID =
			"DELETE FROM schedules WHERE schedule_id = ?";
	private static final String SQL_INSERT =
			"INSERT INTO schedules(user_id, schedule_contents, upload_datetime, important) VALUES(?, ?, ?, ?)";

	@Autowired
	JdbcTemplate jt;

	@Override
	public List<Schedules> selectScheduleWhereUserIdAndDate(Integer userId, Timestamp dateMin, Timestamp dateMax) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<Schedules> list = jt.query(SQL_SELECT_SCHEDULES_WHERE_USERID_AND_DATE,
				new BeanPropertyRowMapper<Schedules>(Schedules.class), userId, dateMin, dateMax);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;
	}

	@Override
	public List<Schedules> getInpoSche(Users user) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		List<Schedules> list = jt.query(SQL_SELECT_SCHEDULES_WHERE_IMPORTANT,
				new BeanPropertyRowMapper<Schedules>(Schedules.class),user.getUserId());
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());

		return list;
	}

	@Override
	public int updateScheduleWhereScheduleId(Integer scheduleId, String content, Timestamp dateTime,
			boolean important) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = jt.update(SQL_UPDATE_WHERE_SCHEDULEID,
				content, dateTime, important, scheduleId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}

	@Override
	public int deleteScheduleWhereScheduleId(Integer scheduleId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = jt.update(SQL_DELETE_WHERE_SCHEDULEID, scheduleId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}

	@Override
	public int insertSchedule(Integer userId, String content, Timestamp dateTime, boolean important) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int updateCount = jt.update(SQL_INSERT, userId, content, dateTime, important);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return updateCount;
	}

}
