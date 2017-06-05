package jp.co.example.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import enums.LogEnum;
import jp.co.example.dao.ProjectorsDao;
import jp.co.example.entity.Projectors;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Repository
@Slf4j
public class ProjectorsDaoImpl implements ProjectorsDao{
	private static final String SQL_SELECT_PROJECTORS_WHERE_TRAININGID_AND_DATE =
			"SELECT * FROM projectors WHERE training_id = ? AND reserve_time BETWEEN ? AND ?";
	private static final String SQL_SELECT_PROJECTORS_WHERE_TRAININGID_AND_DATETIME =
			"SELECT * FROM projectors WHERE training_id = ? AND reserve_time = ?";

	@Autowired
	JdbcTemplate jt;

	@Override
	public List<Projectors> selectProjectorsWhereTrainingIdAndDate(Integer trainingId, Timestamp dateMin,
			Timestamp dateMax) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<Projectors> list = jt.query(SQL_SELECT_PROJECTORS_WHERE_TRAININGID_AND_DATE, new BeanPropertyRowMapper<Projectors>(Projectors.class),
				trainingId, dateMin, dateMax);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;
	}

	@Override
	public List<Projectors> selectProjectorsWhereTrainingIdAndDateTime(Integer trainingId, Timestamp dateTime) {
		// TODO 自動生成されたメソッド・スタブ
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		List<Projectors> list = jt.query(SQL_SELECT_PROJECTORS_WHERE_TRAININGID_AND_DATETIME, new BeanPropertyRowMapper<Projectors>(Projectors.class),
				trainingId, dateTime);

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return list;
	}

}
