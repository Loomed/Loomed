package jp.co.example.service.impl;

import jp.co.example.dao.MapsDao;
import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Users;
import jp.co.example.service.IndexService;

public class IndexServiceImpl implements IndexService{

	UsersDao UsersDao;
	MapsDao MapsDao;

	public Users LoginJudge(int id, String pass){

		//Users LoginUser = UsersDao.FindOneId;
		Users LoginUser = new Users(100,"test","テスト",1,3);

		return LoginUser;

	}

	public int RoomJudge(int id){

		//処理未確定のため
		int RoomNum = 1;

		return RoomNum;
	}
}
