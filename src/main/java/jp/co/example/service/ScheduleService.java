package jp.co.example.service;

import java.util.List;

import jp.co.example.form.ScheduleForm;

public interface ScheduleService {
	List<ScheduleForm> getSchedule(Integer userId, String date);
}
