package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.example.dao.MailsDao;
import jp.co.example.dao.MapsDao;
import jp.co.example.dao.SchedulesDao;
import jp.co.example.dao.SharesDao;
import jp.co.example.dao.TrainingsDao;
import jp.co.example.entity.Maps;
import jp.co.example.entity.Schedules;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;
import jp.co.example.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {
	MailsDao mailsdao;
	SharesDao sharesdao;
	MapsDao mapsdao;
	TrainingsDao trainingsdao;
	SchedulesDao schedulesdao;

	public String getNewMails(Users user) {
		Integer cnt = 0;
		String mailcnt = null;
		cnt = mailsdao.getNewMails(user);
		mailcnt = Integer.toString(cnt);
		return mailcnt;
	}

	public List<Schedules> getInpoSche() {
		List<Schedules> list = new ArrayList<Schedules>();
		list = schedulesdao.getInpoSche();
		return list;

	}

	public Maps getTrainingid(Users user) {
		Maps maps = new Maps();
		maps = mapsdao.getUserTrainigs(user);
		return maps;

	}
	public Trainings getTrainingName(int tr){
		Trainings tra = null;
		tra = trainingsdao.getTraining(tr);
		return tra;

	}
}
