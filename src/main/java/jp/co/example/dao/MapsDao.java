package jp.co.example.dao;

import jp.co.example.entity.*;

public interface MapsDao {

	int getUserTrainigs(Users user);

	int update(int userId, int trainingId);

}
