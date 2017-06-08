package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Trainings;

public interface TrainingConfigService {

	public List<Trainings> AllTrainings();

	void InsTrainings(int pro, String name,String info);

	void DelTrainings(int id);
}
