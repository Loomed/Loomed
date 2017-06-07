package jp.co.example.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import jp.co.example.dao.*;
import jp.co.example.entity.*;
import jp.co.example.service.*;
import lombok.extern.slf4j.*;

@Transactional
@Service
@Slf4j
public class UserChangeServiceImpl implements UserChangeService {

	@Autowired
	private TrainingsDao trainigDao;

	@Autowired
	private CompaniesDao companyDao;

	@Autowired
	private MapsDao mapDao;

	@Override
	public List<Companies> getCompanies() {
		return companyDao.getCompanis();
	}

	@Override
	public List<Trainings> getTrainig() {
		return trainigDao.AllRooms();
	}

	@Override
	public List<Maps> getMaps(Users user) {
		return mapDao.selectWhereUserId(user.getUserId());
	}
}
