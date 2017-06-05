package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.dao.SchedulesDao;
import jp.co.example.entity.Schedules;
import jp.co.example.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	SchedulesDao sd;

	@Override
	public List<Schedules> getSchedule(String date) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<Schedules> list = 

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;
	}

}
