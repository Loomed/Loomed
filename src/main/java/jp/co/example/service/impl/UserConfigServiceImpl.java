package jp.co.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import enums.LogEnum;
import jp.co.example.dao.*;
import jp.co.example.entity.*;
import jp.co.example.form.UserConfigForm;
import jp.co.example.service.UserConfigService;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Transactional
@Service
@Slf4j
public class UserConfigServiceImpl implements UserConfigService {

	@Autowired
	private UsersDao userDao;

	@Autowired
	private MapsDao mapsDao;

	@Autowired
	private TrainingsDao trainigDao;

	@Autowired
	private CompaniesDao companyDao;

	@Override
	public List<UsersEx> getUser() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<UsersEx> usersEx = new ArrayList<>();

		List<Users> users = userDao.fingAllUsers();
		for (Users tmp : users) {
			UsersEx userEx = new UsersEx(tmp);

			List<Maps> maps = mapsDao.selectWhereUserId(tmp.getUserId());

			List<Trainings> trainings = new ArrayList<>();
			for (Maps map : maps) {
				trainings.add(trainigDao.getTraining(map.getTrainingId()));
			}

			userEx.setTrainings(trainings);
			userEx.setAuthName(Util.getAuthorityName(tmp.getAuthority()));

			usersEx.add(userEx);
		}

		return usersEx;
	}

	@Override
	public List<Companies> getCompanies() {
		return companyDao.getCompanis();
	}

	@Override
	public List<Trainings> getTrainig() {
		return trainigDao.AllRooms();
	}

	@Override
	public int insert(UserConfigForm user, Maps[] maps) {

		if (user.getCompanyId() == null) {
			companyDao.insert(user.getCompanyName());
			user.setCompanyId(companyDao.findCompanyId(user.getCompanyName()).get(0).getCompanyId());
		}
		Integer userId = userDao.insert(user.getUserName(), user.getPassword(), user.getCompanyId(),
				user.getAuthority());

		// ユーザのマップをすべて削除してから複数のマップを登録する
		mapsDao.delete(userId);

		if (maps != null) {
			for (Maps map : maps) {
				mapsDao.update(userId, map.getTrainingId());
			}
		}

		return 0;
	}

	@Override
	public int delete(Users user) {
		return userDao.delete(user.getUserId());
	}

	@Override
	public List<List<Maps>> getUserListMaps(List<Users> userlist) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
