package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Maps;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;

public interface IndexService {

	public Users LoginJudge(int id, String pass);

	public List<Maps> RoomJudge(int id);

	public boolean isNum(String strId);

	public List<Trainings> AllTrainings();

}
