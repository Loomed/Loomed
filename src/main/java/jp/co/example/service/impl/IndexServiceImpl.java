package jp.co.example.service.impl;

import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.dao.MapsDao;
import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Users;
import jp.co.example.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@Service
public class IndexServiceImpl implements IndexService{

	UsersDao UsersDao;
	MapsDao MapsDao;

	public Users LoginJudge(int id, String pass){
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//Users LoginUser = UsersDao.FindOneId;
		Users LoginUser = new Users(100,"test","テスト",1,3);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return LoginUser;

	}

	public int RoomJudge(int id){
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		//処理未確定のため
		int RoomNum = 1;

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
}
