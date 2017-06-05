package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import jp.co.example.dao.MailsDao;
import jp.co.example.dao.SchedulesDao;
import jp.co.example.dao.SharesDao;
import jp.co.example.dao.TrainingsDao;
import jp.co.example.entity.Schedules;
import jp.co.example.entity.Users;
import jp.co.example.service.HomeService;

public class HomeServiceImpl implements HomeService {
	MailsDao mailsdao;
	SharesDao sharesdao;
	TrainingsDao trainingsdao;
	SchedulesDao schedulesdao;
	public int getNewMails(Users user){
		int cnt = 0;
		cnt =  mailsdao.getNewMails(user);
		return cnt;
	}
	public List<Schedules> getInpoSche(){
	List<Schedules> list = new ArrayList<Schedules>();
		list = schedulesdao.getInpoSche();
		return list;

	}
}
