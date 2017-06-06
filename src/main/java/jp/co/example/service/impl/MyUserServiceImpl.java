package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import jp.co.example.dao.*;
import jp.co.example.entity.*;
import jp.co.example.service.*;

@Service
public class MyUserServiceImpl implements MyUserService {


	@Autowired
	private UsersDao userDao;

	@Override
	public int Update(Users user){
		return userDao.update(user.getUserId(), user.getPassword(), user.getUserName(), user.getCompanyId(), user.getAuthority());
	}
}
