package jp.co.example.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.SharesDao;
import jp.co.example.entity.Trainings;
import jp.co.example.service.ShareService;
@Service
public class ShareServiceImpl implements ShareService{
	@Autowired
	SharesDao sd;

	public void InsertFile(Trainings tra, StringBuffer filePath,String filename, boolean radio){
		Date uploaddate = new Date();
	        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    String upload =  sdf1.format(uploaddate);
		sd.insertFilepass(tra,filePath,upload,filename,radio);
	}


}
