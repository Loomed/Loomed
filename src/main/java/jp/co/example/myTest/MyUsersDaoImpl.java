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
	public MyUsers loginUser(int id, String pass) {
		MyUsers users = null;
		users = jdbcTemplate.queryForObject(SELECT, new BeanPropertyRowMapper<MyUsers>(MyUsers.class),id, pass);
		return users;
	}

	@Override
	public MyUsers getUser(int id) {
		MyUsers users = null;
		log.info("id : " + id);
		users = jdbcTemplate.queryForObject(SELECT2, new BeanPropertyRowMapper<MyUsers>(MyUsers.class),id);
		return users;
	}

}
