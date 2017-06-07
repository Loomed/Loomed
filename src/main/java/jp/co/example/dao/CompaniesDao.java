package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Companies;
import jp.co.example.entity.Users;

public interface CompaniesDao {
	Companies getCompanieName(Integer userId);

	List<Companies> FindRoomMemberComp(List<Users> members);
}
