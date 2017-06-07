package jp.co.example.dao;

import java.util.*;

import jp.co.example.entity.*;

public interface CompaniesDao {
	Companies getCompanieName(Integer userId);

	List<Companies> getCompanis();
}
