package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Schedules;
import jp.co.example.entity.Shares;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;

public interface HomeService {
	public String getNewMails(Users user);
	public List<Schedules> getInpoSche(Users user);
	public Trainings getTrainingName(int tr);
	public void setOutPutStream(List<Shares> sl);
}
