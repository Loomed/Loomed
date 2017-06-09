package jp.co.example.service;

import java.util.*;

import jp.co.example.entity.*;

public interface UserInfoService {
	/**
	 * 更新を行います
	 * 権限によって更新内容が変わります。
	 *
	 * @param auth 更新実施者
	 * @param user 更新対象者
	 * @param map
	 * @return
	 */
	int update(Users auth, UsersEx user, Maps[] maps);

	UsersEx getUser(Users user);

	List<Trainings> getTrainig();

	List<Companies> getComapnies(String company);

}
