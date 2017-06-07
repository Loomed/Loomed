package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.TrainingsDao;
import jp.co.example.entity.Trainings;
import jp.co.example.service.TrainingChangeService;

@Service
public class TrainingChangeServiceImpl implements TrainingChangeService{

	@Autowired
	TrainingsDao TrainingsDao;

	@Override
	public Trainings OneRoom(int id){

		return null;
	}

}
