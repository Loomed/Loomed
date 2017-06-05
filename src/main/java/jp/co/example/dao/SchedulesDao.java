package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Schedules;

public interface SchedulesDao {
	List<Schedules> SelectScheduleWhereUserId(Integer userId);
}
