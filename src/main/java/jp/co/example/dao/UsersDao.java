package jp.co.example.dao;

import java.util.*;

import jp.co.example.entity.*;

public interface UsersDao {
	Users findByIdAndPass(Integer userId, String password);

	Users findById(Integer userId);

	int updateAll(Integer userId, String password, String userName, Integer companyId, Integer authority);

	int updatePass(Integer userId, String password);

	public List<Users> FindCompMember(int comId);

	public List<Users> FindRoomMember(int roomId);

	List<Users> fingAllUsers();
}
