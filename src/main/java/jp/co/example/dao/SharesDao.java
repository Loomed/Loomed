package jp.co.example.dao;

import java.sql.Timestamp;

import jp.co.example.entity.Trainings;

public interface SharesDao {

	public void insertFilepass(Trainings tra, StringBuffer filePath,Timestamp upload, String filename, boolean radio);

}
