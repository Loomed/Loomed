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
	public int update(Users auth, UsersEx user, Maps[] maps) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		try {
			if (auth.getAuthority() <= 1) {
				if(user.getCompanyId() == null)
				{
					companyDao.insert(user.getCompanyName());
					user.setCompanyId(companyDao.findCompanyId(user.getCompanyName()).get(0).getCompanyId());
				}
				userDao.updateAll(user.getUserId(), user.getPassword(), user.getUserName(), user.getCompanyId(),
						user.getAuthority());

				//ユーザのマップをすべて削除してから複数のマップを登録する
				userDao.delete(user.getUserId());
				for (Maps map : maps) {
					mapsDao.update(map.getUserId(), map.getTrainingId());
				}
			} else {
				userDao.updatePass(user.getUserId(), user.getPassword());
			}
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return 1;
		} catch (DataAccessException e) {
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return 0;
		}
	}

	@Override
	public UsersEx getUser(Users user) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		Users tmp = userDao.findById(user.getUserId());
		// log.info("trainig id :" +
		// mapsDao.selectWhereUserId(u.getUserId()).size());

		UsersEx userEx = new UsersEx(tmp);
		userEx.setCompanyName(companyDao.findCompany(tmp.getCompanyId()).getCompanyName());
		List<Maps> maps = mapsDao.selectWhereUserId(tmp.getUserId());

		List<Trainings> trainings = new ArrayList<>();
		for (Maps map : maps) {
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

	@Override
	public List<Companies> getComapnies(String company) {
		return companyDao.findCompanyId(company);
	}
}
