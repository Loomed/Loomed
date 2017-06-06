package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import jp.co.example.dao.*;
import jp.co.example.entity.*;

@Repository
public class CompaniesDaoImpl implements CompaniesDao {
	private static final String SQL_SELECT = "SELECT * FROM companies WHERE company_id = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Companies getCompanieName(Integer companieId) {
		try {
			return jdbcTemplate.queryForObject(SQL_SELECT, new BeanPropertyRowMapper<Companies>(Companies.class), companieId);
		} catch (DataAccessException e) {
			return null;
		}
	}

}
