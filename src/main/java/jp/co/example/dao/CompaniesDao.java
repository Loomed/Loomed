package jp.co.example.dao;

import java.util.*;

import jp.co.example.entity.*;

public interface CompaniesDao {
	List<Companies> findCompanyId(String companyName);

	Companies findCompany(Integer userId);

	List<Companies> FindRoomMemberComp(List<Users> members);

	List<Companies> getCompanis();

	int insert(String companyName);
}
