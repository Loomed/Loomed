package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import enums.LogEnum;
import jp.co.example.dao.TrainingsDao;
import jp.co.example.entity.Trainings;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Repository
@Slf4j
public class TrainingsDaoImpl implements TrainingsDao{

	private static final String SQL_SELECT_ALL_TRAININGS = "SELECT * FROM trainings ORDER BY training_id ASC";
	private static final String SQL_SELECT__TRAININGS_WHERE_TRAININGID = "SELECT * FROM trainings WHERE training_id = ?";
	private static final String SQL_SELECT_MAX_TRAININGS = "SELECT * FROM trainings ORDER BY training_id DESC LIMIT 1";
	private static final String SQL_INS = "INSERT INTO trainings(training_name,projector_count,training_info) VALUES (?, ?, ?)";
	private static final String SQL_DEL = "DELETE FROM trainings WHERE training_id = ?";
	private static final String SQL_UPD = "UPDATE trainings SET training_name = ?,projector_count = ?,training_info = ? WHERE training_id = ?";

	@Autowired
 	private JdbcTemplate jdbcTemplate;//

	@Override
	public List<Trainings> AllRooms() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return jdbcTemplate.query(SQL_SELECT_ALL_TRAININGS, new BeanPropertyRowMapper<Trainings>(Trainings.class));
	}

	@Override
	public Trainings getTraining(int tr) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		Trainings tra = jdbcTemplate.queryForObject(SQL_SELECT__TRAININGS_WHERE_TRAININGID, new BeanPropertyRowMapper<Trainings>(Trainings.class), tr);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return tra;
	}

	//Idのみ取得用→使わない
	@Override
	public int getTrainingId() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		Trainings tra = jdbcTemplate.queryForObject(SQL_SELECT_MAX_TRAININGS, new BeanPropertyRowMapper<Trainings>(Trainings.class));
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());

		return tra.getTrainingId();

	}

	@Override
	public int InsTraining(int pro,String name,int TraMaxNum,String info) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		int res = jdbcTemplate.update(SQL_INS,name,pro,info);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());

		return res;

	}

	@Override
	public int DelTraining(int id) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		int res = jdbcTemplate.update(SQL_DEL,id);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());

		return res;

	}


	@Override
	public int UpdTraining(int id,String name,int pro,String info) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		int res = jdbcTemplate.update(SQL_UPD,name,pro,info,id);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());

		return res;

	}


}
