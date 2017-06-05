package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.UsersDao;
import jp.co.example.entity.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	private static final String SQL_SELECT_ID_AND_PASS = "SELECT * FROM users WHERE user_id = ? AND password = ?";
	private static final String SQL_SELECT_ID = "SELECT * FROM users WHERE user_id = ?";
	private static final String UPDATE ="UPDATE users SET password = ?, user_name = ?, company_id = ?, authority = ? WHERE user_id = ?";
	private static final String SQL_MEMBER_SELECT ="SELECT * FROM users WHERE company_id = ?";

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

	@Override
	public Users findById(Integer userId) {
		// TODO 自動生成されたメソッド・スタブ
		Users users = null;
		try {
			users = jdbcTemplate.queryForObject(SQL_SELECT_ID, new BeanPropertyRowMapper<Users>(Users.class),
					userId);
		} catch (DataAccessException e) {
			users = null;
		}

		return users;
	}

	@Override
	public List<Users> FindMember(int roomId, int comId){
		//作成途中
		List<Users> member = null;
		try {
			member = jdbcTemplate.query(SQL_MEMBER_SELECT, new BeanPropertyRowMapper<Users>(Users.class),
					comId);
		} catch (DataAccessException e) {
			member = null;
		}

		return member;
	}

}
