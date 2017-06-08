package jp.co.example.dao;

import java.sql.Timestamp;
import java.util.List;

import jp.co.example.entity.Shares;
import jp.co.example.entity.Trainings;

public interface SharesDao {

	public List<Shares> selectlist(Integer trainingid);

	public void changeVisible(int id, boolean visible);

	public void deleteShare(int id);

	public void insertFilepass(Trainings tra, String filePath, Timestamp upload, String filename, boolean radio);

}
