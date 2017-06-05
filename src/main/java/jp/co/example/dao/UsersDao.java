package jp.co.example.dao;

import jp.co.example.entity.Users;

public interface UsersDao {
	Users findByIdAndPass(Integer userId, String password);
	Users findById(Integer userId);

	int update(Integer userId, String password, String userName, Integer companyId, Integer authority);
}
