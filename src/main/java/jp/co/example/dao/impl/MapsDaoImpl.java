package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import enums.LogEnum;
import jp.co.example.dao.MapsDao;
import jp.co.example.entity.Maps;
import jp.co.example.form.ReserveUserNameForm;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Repository
@Slf4j
public class MapsDaoImpl implements MapsDao{
	private final String SQL_SELECT_MAPS_WHERE_USERID_AND_TRAININGID ="SELECT * FROM maps WHERE user_id = ? ; ";
	private final String UPDATE = "UPDATE maps SET training_Id = ? WHERE user_id = ? ";
	private final String SQL_SELECT_USERID_USERNAME_JOIN_USERS =
			"SELECT maps.user_id, user_name FROM maps JOIN users ON maps.user_id = users.user_id WHERE maps.user_id <> ? AND training_id = ?";

	@Autowired
	JdbcTemplate jt;

	@Override
	public List<Maps> selectWhereUserId(Integer userId) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<Maps> map = jt.query(SQL_SELECT_MAPS_WHERE_USERID_AND_TRAININGID,
				new BeanPropertyRowMapper<Maps>(Maps.class), userId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return map;
	}

	/**
	 *  2017/06/06
	 *  @author sakata
	 */
	@Override
	public int update(int userId, int trainingId) {
		return jt.update(UPDATE, trainingId, userId);//
	}

	@Override
	public List<ReserveUserNameForm> selectUserIDAndUserNameJoinUsers(Integer userId, Integer trainingId) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<ReserveUserNameForm> rUserNameForm = jt.query(SQL_SELECT_USERID_USERNAME_JOIN_USERS,
				new BeanPropertyRowMapper<ReserveUserNameForm>(ReserveUserNameForm.class), userId, trainingId);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return rUserNameForm;
	}

}
