package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Shares;
import jp.co.example.entity.Trainings;

public interface ShareService {
	public void InsertFile(Trainings tra, String dlpath,String filename, boolean radio);

	public List<Shares> selectlist(Integer trainingid);

	public void changeVisible(int id, boolean visible);

	public void deleteShare(int id);

	public List<Shares> selectvisiblelist(Integer trainingid);
}
