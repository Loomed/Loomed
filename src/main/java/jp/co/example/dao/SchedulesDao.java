package jp.co.example.dao;

import java.sql.Timestamp;
import java.util.List;

import jp.co.example.entity.Schedules;

public interface SchedulesDao {
	List<Schedules> selectScheduleWhereUserIdAndDate(Integer userId, Timestamp dateMin, Timestamp dateMax);
}
