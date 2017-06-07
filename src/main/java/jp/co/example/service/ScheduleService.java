package jp.co.example.service;

import java.util.List;

import jp.co.example.form.*;

public interface ScheduleService {
	List<ScheduleForm> getSchedule(Integer userId, String date);

	List<ProjectorForm> getProjectorJson(Integer trainingId, String date, String time);

	boolean isProjectorAuthority(Integer userId, Integer trainingId);

	List<ReserveUserNameForm> getReserveUserNameJson(Integer userId, Integer trainingId);
}
