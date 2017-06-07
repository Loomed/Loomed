package jp.co.example.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.SharesDao;
import jp.co.example.entity.Trainings;
import jp.co.example.service.ShareService;
@Service
public class ShareServiceImpl implements ShareService{
	private static final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	@Autowired
	SharesDao sd;

	public void InsertFile(Trainings tra, StringBuffer filePath,String filename, boolean radio){
		Timestamp upload = new Timestamp(System.currentTimeMillis());
		sd.insertFilepass(tra,filePath,upload,filename,radio);
	}


}
