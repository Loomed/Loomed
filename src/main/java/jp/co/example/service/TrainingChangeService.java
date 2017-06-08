package jp.co.example.service;

import jp.co.example.entity.Trainings;

public interface TrainingChangeService {
	public Trainings OneRoom(int id);
	public void UpdTrainings(int id,String name,int pro);
}
