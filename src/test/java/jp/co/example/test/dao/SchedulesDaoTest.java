package jp.co.example.test.dao;

import java.sql.Timestamp;
import java.util.List;

import jp.co.example.entity.Schedules;

public interface SchedulesDaoTest {
	List<Schedules> selectScheduleWhereUserIdAndDate(Integer userId, Timestamp dateMin, Timestamp dateMax);

	List<Schedules> getInpoSche();


}
