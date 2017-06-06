package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.MapsDao;
import jp.co.example.entity.Maps;
import jp.co.example.entity.Users;

@Repository
public class MapsDaoImpl implements MapsDao{
	private final String SQL_SELECT_MAPS_WHERE_USERID_AND_TRAININGID ="SELECT * FROM maps WHERE user_id = ? ; ";
	private final String UPDATE = "UPDATE maps SET training_Id = ? WHERE user_id = ? ";

	@Autowired
	JdbcTemplate jt;

	@Override
	public int getUserTrainigs(Users user) {
		Maps map = (Maps) jt.query(SQL_SELECT_MAPS_WHERE_USERID_AND_TRAININGID,
				new BeanPropertyRowMapper<Maps>(Maps.class));
		int tid = map.getTrainingId();
		return tid;
	}

	/**
	 *  2017/06/06
	 *  @author sakata
	 */
	@Override
	public int update(int userId, int trainingId) {
		return jt.update(UPDATE, trainingId, userId);//
	}

}
