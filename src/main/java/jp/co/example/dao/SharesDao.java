package jp.co.example.dao;

import java.sql.Timestamp;
import java.util.List;

import jp.co.example.entity.Shares;
import jp.co.example.entity.Trainings;

public interface SharesDao {

	public void insertFilepass(Trainings tra, StringBuffer filePath,Timestamp upload, String filename, boolean radio);

	public List<Shares> selectlist(Integer trainingid);

	public void changeVisible(int id, boolean visible);

	public void deleteShare(int id);

}
