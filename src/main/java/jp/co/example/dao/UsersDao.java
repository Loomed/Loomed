package jp.co.example.dao;

import jp.co.example.entity.Users;

public interface UsersDao {
	Users findByIdAndPass(Integer userId, String password);

	int update(Integer userId, String Password password, String userName, Integer companyId, );
}
