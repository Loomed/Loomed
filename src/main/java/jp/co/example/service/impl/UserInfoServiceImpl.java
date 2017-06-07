package jp.co.example.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import enums.*;
import jp.co.example.dao.*;
import jp.co.example.entity.*;
import jp.co.example.service.*;
import lombok.extern.slf4j.*;
import util.*;

@Transactional
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UsersDao userDao;

	@Autowired
	private MapsDao mapsDao;

	@Autowired
	private TrainingsDao trainigDao;

	@Autowired
	private CompaniesDao companyDao;

	/**
	 * usersテーブルの更新を行う
	 *
	 * @Author sakata
	 * @return 成功 1、 失敗 0
	 */
	@Override
	public int Update(Users user, Maps map){
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		try{
			userDao.update(user.getUserId(), user.getPassword(), user.getUserName(), user.getCompanyId(), user.getAuthority());
			mapsDao.update(map.getUserId(), map.getTrainingId());
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return 1;
		}
		catch(DataAccessException e)
		{
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return 0;
		}
	}

	@Override
	public UsersEx getUser(Users user) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Users tmp = userDao.findById(user.getUserId());
		//log.info("trainig id :" + mapsDao.selectWhereUserId(u.getUserId()).size());

		UsersEx userEx = new UsersEx(tmp);
		userEx.setCompanyName(companyDao.getCompanieName(tmp.getCompanyId()).getCompanyName());
		List<Maps> maps = mapsDao.selectWhereUserId(tmp.getUserId());

		List<Trainings> trainings = new ArrayList<>();
		for(Maps map : maps)
		{
			trainings.add(trainigDao.getTraining(map.getTrainingId()));
		}

		userEx.setTrainings(trainings);
		userEx.setAuthName(Util.getAuthorityName(tmp.getAuthority()));

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return userEx;
	}

	@Override
	public List<Trainings> getTrainig() {
		return trainigDao.AllRooms();
	}
}
