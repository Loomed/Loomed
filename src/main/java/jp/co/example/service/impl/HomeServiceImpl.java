package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.dao.MailsDao;
import jp.co.example.dao.MapsDao;
import jp.co.example.dao.SchedulesDao;
import jp.co.example.dao.SharesDao;
import jp.co.example.dao.TrainingsDao;
import jp.co.example.entity.Schedules;
import jp.co.example.entity.Shares;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;
import jp.co.example.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Service
@Slf4j
public class HomeServiceImpl implements HomeService {
	@Autowired
	MailsDao mailsdao;
	@Autowired
	SharesDao sharesdao;
	@Autowired
	MapsDao mapsdao;
	@Autowired
	TrainingsDao trainingsdao;
	@Autowired
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

	public List<Schedules> getInpoSche(Users user) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		List<Schedules> list = new ArrayList<Schedules>();
		try {
			list = schedulesdao.getInpoSche(user);
		} catch (Exception e) {
			list = null;
		}
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;

	}

	public Trainings getTrainingName(int tr) {
		System.out.println(tr);
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		Trainings tra ;
			tra = trainingsdao.getTraining(tr);
			System.out.println(tra);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return tra;

	}

	@Override
	public void setOutPutStream(List<Shares> sl) {
		List<Shares> list = sl;

	}
}
