package jp.co.example.myTest;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import jp.co.example.dao.*;
import jp.co.example.entity.*;

@Service
public class MyUsersServiceImpl implements MyUsersService{

	@Autowired
	private MyUsersDao myUserDao;

	@Autowired
	private TrainingsDao trainingDao;

	@Override
	public Users login(Users user) {
		return myUserDao.loginUser(user.getUserId(), user.getPassword());
	}

	@Override
	public Users getUser(Users user) {
		/*
		Users u = myUserDao.getUser(user.getUserId());

		MyUsers myUser = (MyUsers) u;
		myUser.setCompanyName(trainingDao.getTraining());

*/

		return myUserDao.getUser(user.getUserId());
	}

}
