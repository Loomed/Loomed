package jp.co.example.dao;

import java.sql.Timestamp;
import java.util.List;

import jp.co.example.entity.Schedules;

public interface SchedulesDao {
	List<Schedules> selectScheduleWhereUserIdAndDate(Integer userId, Timestamp dateMin, Timestamp dateMax);

	List<Schedules> getInpoSche();

	int updateScheduleWhereScheduleId(Integer scheduleId, String content, Timestamp dateTime, boolean important);

	int deleteScheduleWhereScheduleId(Integer scheduleId);

	int insertSchedule(Integer userId, String content, Timestamp dateTime, boolean important);
}
