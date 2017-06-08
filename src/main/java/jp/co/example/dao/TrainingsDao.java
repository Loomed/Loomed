package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Trainings;

public interface TrainingsDao {

	List<Trainings> AllRooms() ;

	Trainings getTraining(int tr);

	int getTrainingId();

	int InsTraining(int pro,String name,int TraMaxNum, String info);

	int DelTraining(int id);

	int UpdTraining(int id,String name,int pro,String info);
}
