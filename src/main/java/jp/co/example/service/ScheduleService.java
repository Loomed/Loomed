package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Schedules;

public interface ScheduleService {
	List<Schedules> getSchedule(String date);
}
