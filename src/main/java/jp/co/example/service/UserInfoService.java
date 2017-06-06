package jp.co.example.service;

import java.util.*;

import jp.co.example.entity.*;

public interface UserInfoService {
	int Update(Users user, Maps map);

	UsersEx getUser(Users user);

	List<Trainings> getTrainig();
}
