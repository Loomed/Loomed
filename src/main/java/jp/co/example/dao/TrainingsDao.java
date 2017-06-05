package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Trainings;

public interface TrainingsDao {

	public List<Trainings> AllRooms() ;

	public Trainings getTraining(int tr);

}
