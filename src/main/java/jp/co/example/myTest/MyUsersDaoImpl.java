package jp.co.example.myTest;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import jp.co.example.entity.*;
import lombok.extern.slf4j.*;


@Slf4j
@Repository
public class MyUsersDaoImpl implements MyUsersDao {
	private static final String SELECT = "SELECT * FROM users WHERE user_id = ? AND password = ?";
	private static final String SELECT2 = "SELECT * FROM users WHERE user_id = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Users loginUser(int id, String pass) {
		Users users = null;
		users = jdbcTemplate.queryForObject(SELECT, new BeanPropertyRowMapper<Users>(Users.class),id, pass);
		return users;
	}

	@Override
	public Users getUser(int id) {
		Users users = null;
		log.info("id : " + id);
		users = jdbcTemplate.queryForObject(SELECT2, new BeanPropertyRowMapper<Users>(Users.class),id);
		return users;
	}

}
