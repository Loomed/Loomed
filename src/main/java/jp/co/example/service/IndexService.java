package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;

public interface IndexService {

	public Users LoginJudge(int id, String pass);

	public int RoomJudge(int id);

	public boolean isNum(String strId);

	public List<Trainings> AllTrainings();

}
