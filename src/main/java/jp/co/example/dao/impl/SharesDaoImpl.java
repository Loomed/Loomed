package jp.co.example.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.SharesDao;
import jp.co.example.entity.Shares;
import jp.co.example.entity.Trainings;

@Repository
public class SharesDaoImpl implements SharesDao{
	private final String INSERT_INTO_SHARES ="INSERT INTO SHARES(training_id,share_contents,upload_date,visible,title)VALUES(?,?,?,?,?)";
	private final String SELECT_FROM_SHARES_ALL = "SELECT * FROM shares WHERE training_id =? ORDER BY share_id DESC";
	private final String UPDATE_SHARES_SET_VISIBLE = "UPDATE shares SET visible =? WHERE share_id = ?";
	private final String DELETE_FROM_SHARES_WHERE ="DELETE FROM shares WHERE share_id = ?";
	@Autowired
	JdbcTemplate jt;
	@Override
	public void insertFilepass(Trainings tra, StringBuffer filePath,Timestamp uploaddate, String filename, boolean radio) {
		jt.update(INSERT_INTO_SHARES,tra.getTrainingId(),filePath,uploaddate,radio,filename);

	}
	@Override
	public List<Shares> selectlist(Integer trainingid) {
		List<Shares> list = new ArrayList<Shares>();
		list = jt.query(SELECT_FROM_SHARES_ALL, new BeanPropertyRowMapper<Shares>(Shares.class), trainingid);
		return list;
	}
	@Override
	public void changeVisible(int id, boolean visible) {
		 jt.update(UPDATE_SHARES_SET_VISIBLE,visible,id);
	}
	@Override
	public void deleteShare(int id) {
		 jt.update(DELETE_FROM_SHARES_WHERE,id);

	}

}
