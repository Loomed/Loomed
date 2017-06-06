package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.MapsDao;
import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Maps;
import jp.co.example.entity.Users;
import jp.co.example.service.UserInfoService;

@Transactional
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UsersDao userDao;

	@Autowired
	private MapsDao mapsDao;

	/**
	 * usersテーブルの更新を行う
	 *
	 * @Author sakata
	 * @return 成功 1、 失敗 0
	 */
	@Override
	public int Update(Users user, Maps map){
		try{
			userDao.update(user.getUserId(), user.getPassword(), user.getUserName(), user.getCompanyId(), user.getAuthority());
			mapsDao.update(map.getUserId(), map.getTrainingId());
			return 1;
		}
		catch(DataAccessException e)
		{
			return 0;
		}
	}

	@Override
	public Users getUser(Users user) {
		return userDao.findById(user.getUserId());//
	}
}
