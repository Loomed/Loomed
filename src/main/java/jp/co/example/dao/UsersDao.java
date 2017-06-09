package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Users;

public interface UsersDao {
	Users findByIdAndPass(Integer userId, String password);

	Users findById(Integer userId);

	int updateAll(Integer userId, String password, String userName, Integer companyId, Integer authority);

	int updatePass(Integer userId, String password);

	public List<Users> FindCompMember(int comId,int roomId);

	public List<Users> FindRoomMember(int roomId);

	List<Users> fingAllUsers();

	List<Users> findAuthUsers(int authority);

	Integer insert(String userName, String password,  Integer companyId, Integer authority);

	int delete(Integer userId);
}
