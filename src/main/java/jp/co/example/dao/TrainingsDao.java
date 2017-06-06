package jp.co.example.dao;

import java.util.*;

import jp.co.example.entity.*;

public interface TrainingsDao {

	List<Trainings> AllRooms() ;

	Trainings getTraining(int tr);
}
