package jp.co.example.test.dao;

import java.util.List;

import jp.co.example.entity.Users;

public interface UsersDaoTset {
	Users findByIdAndPass(Integer userId, String password);
	Users findById(Integer userId);

	int update(Integer userId, String password, String userName, Integer companyId, Integer authority);

	public List<Users> FindMember(int roomId, int comId);
}
