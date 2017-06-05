package jp.co.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Users;
import jp.co.example.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Autowired
	private UsersDao usersDao;

	@Override
	public Users findByIdAndPass(Integer userId, String password) {
		return usersDao.findByIdAndPass(userId, password);
	}
}