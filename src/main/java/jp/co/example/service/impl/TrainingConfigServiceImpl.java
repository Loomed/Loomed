package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.dao.TrainingsDao;
import jp.co.example.entity.Trainings;
import jp.co.example.service.TrainingConfigService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Service
@Slf4j
public class TrainingConfigServiceImpl implements TrainingConfigService {

	@Autowired
	TrainingsDao TrainingsDao;

	@Override
	public List<Trainings> AllTrainings() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<Trainings> AllRoom = new ArrayList<>();

		AllRoom = TrainingsDao.AllRooms();
		// AllRoom.add(new Trainings(0,"全体管理",6,"test:root"));
		// AllRoom.add(new Trainings(1,"経験者Java(品川教室)",1,"test:a"));
		// AllRoom.add(new Trainings(2,"未経験者Java(品川教室)",2,"test:b"));
		// AllRoom.add(new Trainings(3,"未経験者Java(A教室)",3,"test:c"));

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return AllRoom;

	}

	@Override
	public void InsTrainings(int pro, String name,String info) {

		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int TraMaxNum = 0;
		TraMaxNum = TrainingsDao.getTrainingId() + 1;

		int res = TrainingsDao.InsTraining(pro, name, TraMaxNum,info);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
	}

	@Override
	public void DelTrainings(int id) {

		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		int res = TrainingsDao.DelTraining(id);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
	}
}
