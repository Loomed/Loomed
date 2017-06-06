package jp.co.example.test.dao;

import jp.co.example.entity.Maps;
import jp.co.example.entity.Users;

public interface MapsDaoTest {

	Maps getUserTrainigs(Users user);

	int update(int userId, int trainingId);

}
