package jp.co.example.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.LogEnum;
import jp.co.example.dao.SharesDao;
import jp.co.example.entity.Shares;
import jp.co.example.entity.Trainings;
import jp.co.example.service.ShareService;
import lombok.extern.slf4j.Slf4j;
import util.Util;
@Service
@Slf4j
public class ShareServiceImpl implements ShareService{

	@Autowired
	SharesDao sd;

	public void InsertFile(Trainings tra, String filePath,String filename, boolean radio){
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		Timestamp upload = new Timestamp(System.currentTimeMillis());
		sd.insertFilepass(tra,filePath,upload,filename,radio);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
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
