package jp.co.example.dao.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import enums.*;
import jp.co.example.dao.*;
import jp.co.example.entity.*;
import lombok.extern.slf4j.*;
import util.*;

@Slf4j
@Repository
public class UsersDaoImpl implements UsersDao {
	private static final String SQL_SELECT_ID_AND_PASS = "SELECT * FROM users WHERE user_id = ? AND password = ?";
	private static final String SQL_SELECT_ID = "SELECT * FROM users WHERE user_id = ?";
	private static final String UPDATE_PASS ="UPDATE users SET password = ? WHERE user_id = ?";
	private static final String UPDATE_ALL ="UPDATE users SET password = ?, user_name = ?, company_id = ?, authority = ? WHERE user_id = ?";
	private static final String SQL_MEMBER_SELECT_COMP ="SELECT * FROM users WHERE company_id = ?";
	private static final String SQL_MEMBER_SELECT_ROOM ="SELECT * FROM maps WHERE training_id = ?";
	private static final String SQL_SELECT_ALL = "SELECT * FROM users";

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
	public int updateAll(Integer userId, String password, String userName, Integer companyId, Integer authority) {
		return jdbcTemplate.update(UPDATE_ALL, password, userName, companyId, authority, userId);
	}

	@Override
	public int updatePass(Integer userId, String password)
	{
		return jdbcTemplate.update(UPDATE_PASS, password);
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
	public List<Users> FindCompMember(int comId){
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		List<Users> member = null;
		try {
			member = jdbcTemplate.query(SQL_MEMBER_SELECT_COMP, new BeanPropertyRowMapper<Users>(Users.class),
					comId);
		} catch (DataAccessException e) {
			member = null;
		}
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return member;
	}

	@Override
	public List<Users> FindRoomMember(int roomId){
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		List<Users> member = new ArrayList<>(); ;
		List<Maps> mapsUserId = null;
		Users memberOne = null;
		try {
			mapsUserId = jdbcTemplate.query(SQL_MEMBER_SELECT_ROOM, new BeanPropertyRowMapper<Maps>(Maps.class),
					roomId);
			for(int i=0; i<mapsUserId.size();i++){
				memberOne = jdbcTemplate.queryForObject(SQL_SELECT_ID, new BeanPropertyRowMapper<Users>(Users.class),
						mapsUserId.get(i).getUserId());
				if(memberOne != null){
					member.add(memberOne);
				}
			}

		} catch (DataAccessException e) {
			member = null;
		}
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return member;
	}

	@Override
	public List<Users> fingAllUsers() {
		return jdbcTemplate.query(SQL_SELECT_ALL, new BeanPropertyRowMapper<Users>(Users.class));
	}

}
