package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.dao.MapsDao;
import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Trainings;
import jp.co.example.entity.Users;
import jp.co.example.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Service
public class IndexServiceImpl implements IndexService {

	UsersDao UsersDao;
	MapsDao MapsDao;

	public Users LoginJudge(int id, String pass) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		// Users LoginUser = UsersDao.FindOneId;
		Users LoginUser = new Users(100, "test", "テスト", 1, 3);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return LoginUser;

	}

	public int RoomJudge(int id) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		// 処理未確定のため
		int RoomNum = 2;

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return RoomNum;
	}

	public boolean isNum(String strId) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		try {
			Integer.parseInt(strId);
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return true;
		} catch (NumberFormatException e) {
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return false;
		}
	}

	public List<Trainings> AllTrainings() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		// 処理未確定のため擬似作成
		List<Trainings> AllRoom = new ArrayList();
		AllRoom.add(new Trainings(0,"全体管理",6,"test:root"));
		AllRoom.add(new Trainings(1,"経験者Java(品川教室)",1,"test:a"));
		AllRoom.add(new Trainings(2,"未経験者Java(品川教室)",2,"test:b"));
		AllRoom.add(new Trainings(3,"未経験者Java(A教室)",3,"test:c"));

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return AllRoom;
	}
}
