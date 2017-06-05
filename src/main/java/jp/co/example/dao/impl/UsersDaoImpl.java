package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import jp.co.example.dao.*;
import jp.co.example.entity.*;

@Repository
public class UsersDaoImpl implements UsersDao {
	private static final String SQL_SELECT_ID_AND_PASS = "SELECT * FROM users WHERE user_id = ? AND password = ?";
	private static final String UPDATE ="UPDATE users SET password = ?, user_name = ?, company_id = ?, authority = ? WHERE user_id = ?";

	@Autowired
 	private JdbcTemplate jdbcTemplate;

	@Override
	public Users findByIdAndPass(Integer userId, String password) {
		Users users = null;
		try {
			users = jdbcTemplate.queryForObject(SQL_SELECT_ID_AND_PASS, new BeanPropertyRowMapper<Users>(Users.class),
					userId, password);
		} catch (DataAccessException e) {
			users = null;
		}

		return users;
	}

	@Override
	public int update(Integer userId, String password, String userName, Integer companyId, Integer authority) {
		return jdbcTemplate.update(UPDATE, password, userName, companyId, authority);
	}

}
