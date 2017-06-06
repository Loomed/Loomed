package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Maps;

public interface MapsDao {

	List<Maps> selectWhereUserId(Integer userId);

	int update(int userId, int trainingId);

}
