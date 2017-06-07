package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.SharesDao;
import jp.co.example.entity.Trainings;

@Repository
public class SharesDaoImpl implements SharesDao{
	private final String INSERT_INTO_SHARES ="INSERT INTO SHARES(training_id,share_contents,upload_date,visible,title)VALUES(?,?,?,?,?)";

	@Autowired
	JdbcTemplate jt;
	@Override
	public void insertFilepass(Trainings tra, StringBuffer filePath,String uploaddate, String filename, boolean radio) {
		jt.update(INSERT_INTO_SHARES,tra.getTrainingId(),filePath,uploaddate,radio,filename);

	}
}
