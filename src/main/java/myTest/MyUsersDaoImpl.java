package myTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.entity.Users;

@Repository
public class MyUsersDaoImpl implements MyUsersDao {
	private static final String SELECT = "SELECT * FROM users WHERE user_id = ? AND password = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Users LoginUser(int id, String pass) {
		Users users = null;
		users = jdbcTemplate.queryForObject(SELECT, new BeanPropertyRowMapper<Admin>(Admin.class),
				id, pass);
		return null;
	}

}
