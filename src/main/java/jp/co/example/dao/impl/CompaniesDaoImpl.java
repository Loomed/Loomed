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
public class CompaniesDaoImpl implements CompaniesDao {
	private static final String SQL_SELECT = "SELECT * FROM companies WHERE company_id = ?";
	private static final String SQL_SELECT_ALL = "SELECT * FROM companies";

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

	@Override
	public List<Companies> FindRoomMemberComp(List<Users> members){
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		List<Companies> Comp = new ArrayList<>(); ;
		Companies CompOne = null;
		try {
			for(int i=0; i<members.size();i++){
				CompOne = jdbcTemplate.queryForObject(SQL_SELECT, new BeanPropertyRowMapper<Companies>(Companies.class),
						members.get(i).getCompanyId());
				if(CompOne != null){
					Comp.add(CompOne);
				}
			}
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return Comp;
		} catch (DataAccessException e) {
			log.info(Util.getMethodName() + LogEnum.END.getLogValue());
			return null;
		}
	}

	/**
	 *  会社情報をすべて取得する
	 *
	 *  2017/06/07
	 *  @author sakata
	 */
	@Override
	public List<Companies> getCompanis() {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());

		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
		return jdbcTemplate.query(SQL_SELECT_ALL, new BeanPropertyRowMapper<Companies>(Companies.class));
	}

}
