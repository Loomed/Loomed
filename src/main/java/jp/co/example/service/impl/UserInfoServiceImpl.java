package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import jp.co.example.dao.*;
import jp.co.example.entity.*;
import jp.co.example.service.*;

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
		return userDao.findById(user.getUserId());
	}
}
