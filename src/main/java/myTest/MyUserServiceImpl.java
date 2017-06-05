package myTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.entity.Users;

@Service
public class MyUserServiceImpl implements MyUserService{

	@Autowired
	private MyUsersDao myUserDao;

	@Override
	public Users login(Users user) {
		return myUserDao.loginUser(user.getUserId(), user.getPassword());
	}

	@Override
	public Users getUser(Users user) {
		return myUserDao.getUser(user.getUserId());
	}

}
