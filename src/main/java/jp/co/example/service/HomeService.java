package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Schedules;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;

public interface HomeService {
	public String getNewMails(Users user);
	public List<Schedules> getInpoSche();
	public Integer getTrainingid(Users user);
	public Trainings getTrainingName(int tr);
}
