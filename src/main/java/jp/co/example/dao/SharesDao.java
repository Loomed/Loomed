package jp.co.example.dao;

import jp.co.example.entity.Trainings;

public interface SharesDao {

	public void insertFilepass(Trainings tra, StringBuffer filePath,String upload, String filename, boolean radio);

}
