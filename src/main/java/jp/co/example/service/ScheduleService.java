package jp.co.example.service;

import java.util.List;

import jp.co.example.form.ProjectorForm;
import jp.co.example.form.ScheduleForm;

public interface ScheduleService {
	List<ScheduleForm> getSchedule(Integer userId, String date);

	List<ProjectorForm> getProjectorJson(Integer trainingId, String date, String time);
}
