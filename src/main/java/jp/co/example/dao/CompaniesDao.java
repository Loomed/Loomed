package jp.co.example.dao;

import java.util.*;

import jp.co.example.entity.*;

public interface CompaniesDao {
	Companies getCompanieName(Integer userId);

	List<Companies> FindRoomMemberComp(List<Users> members);

	List<Companies> getCompanis();
}
