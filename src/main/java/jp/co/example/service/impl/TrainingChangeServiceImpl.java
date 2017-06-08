package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.dao.TrainingsDao;
import jp.co.example.entity.Trainings;
import jp.co.example.service.TrainingChangeService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Service
@Slf4j
public class TrainingChangeServiceImpl implements TrainingChangeService{

	@Autowired
	TrainingsDao TrainingsDao;

	@Override
	public Trainings OneRoom(int id){
		try{
			return TrainingsDao.getTraining(id);
		}catch(Error e){
			return null;
		}

	}

	@Override
	public void UpdTrainings(int id,String name,int pro) {

		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int res = TrainingsDao.UpdTraining(id,name,pro);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
	}

}
