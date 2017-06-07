package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Trainings;

public interface TrainingsDao {

	List<Trainings> AllRooms() ;

	Trainings getTraining(int tr);
}
