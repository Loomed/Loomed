package jp.co.example.service;

import jp.co.example.entity.Trainings;

public interface ShareService {
	public void InsertFile(Trainings tra, StringBuffer filePath,String filename, boolean radio);

}
