package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.TrainingsDao;
import jp.co.example.entity.Trainings;

@Repository
public class TrainingsDaoImpl implements TrainingsDao{

	private static final String SQL_SELECT_ALL_TRAININGS = "SELECT * FROM trainings ORDER BY training_id ASC";

	@Autowired
 	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Trainings> AllRooms() {
		return jdbcTemplate.query(SQL_SELECT_ALL_TRAININGS, new BeanPropertyRowMapper<Trainings>(Trainings.class));
	}

}
