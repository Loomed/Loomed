package jp.co.example.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.SharesDao;
import jp.co.example.entity.Shares;
import jp.co.example.entity.Trainings;
import jp.co.example.service.ShareService;
@Service
public class ShareServiceImpl implements ShareService{

	@Autowired
	SharesDao sd;

	public void InsertFile(Trainings tra, String filePath,String filename, boolean radio){
		Timestamp upload = new Timestamp(System.currentTimeMillis());
		sd.insertFilepass(tra,filePath,upload,filename,radio);
	}

	@Override
	public List<Shares> selectlist(Integer trainingid) {
		List<Shares> list = new ArrayList<Shares>();
		list = sd.selectlist(trainingid);
		return list;
	}
	public void changeVisible(int id, boolean visible){
		sd.changeVisible(id,visible);

	}

	@Override
	public void deleteShare(int id) {
		sd.deleteShare(id);

	}


}
