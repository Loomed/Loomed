package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.dao.MailsDao;
import jp.co.example.dao.MapsDao;
import jp.co.example.dao.SchedulesDao;
import jp.co.example.dao.SharesDao;
import jp.co.example.dao.TrainingsDao;
import jp.co.example.entity.Maps;
import jp.co.example.entity.Schedules;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;
import jp.co.example.service.RootHomeService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Service
@Slf4j
public class RootHomeServiceImpl implements RootHomeService {
	MailsDao mailsdao;
	SharesDao sharesdao;
	MapsDao mapsdao;
	TrainingsDao trainingsdao;
	SchedulesDao schedulesdao;

	public String getNewMails(Users user) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		Integer mails = 0;
		String mailcnt;
		try {
			mails = mailsdao.getNewMails(user);
		} catch (Exception e) {
			mailcnt = null;
		}
		mailcnt = Integer.toString(mails);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return mailcnt;
	}

	public List<Schedules> getInpoSche() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		List<Schedules> list = new ArrayList<Schedules>();
		try {
			list = schedulesdao.getInpoSche();
		} catch (Exception e) {
			list = null;
		}
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;

	}

	public String getTrainingid(Users user) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		Maps maps = new Maps();
		String tid = null;
		try {
			maps = mapsdao.getUserTrainigs(user);
			tid = Integer.toString(maps.getTrainingId());
		} catch (Exception e) {
			tid = null;
		}
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return tid;

	}

	public Trainings getTrainingName(int tr) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		Trainings tra = null;
		tra = trainingsdao.getTraining(tr);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return tra;

	}
}
