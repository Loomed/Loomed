package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Maps;
import jp.co.example.form.ReserveUserNameForm;

public interface MapsDao {

	List<Maps> selectWhereUserId(Integer userId);

	List<ReserveUserNameForm> selectUserIDAndUserNameJoinUsers(Integer userId, Integer trainingId);

	int update(int userId, int trainingId);

}
