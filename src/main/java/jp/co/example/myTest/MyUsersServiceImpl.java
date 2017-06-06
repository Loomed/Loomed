package jp.co.example.myTest;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import jp.co.example.entity.*;

@Service
public class MyUsersServiceImpl implements MyUsersService{


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
