package jp.co.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import enums.LogEnum;
import jp.co.example.dao.CompaniesDao;
import jp.co.example.entity.Companies;
import jp.co.example.entity.Users;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
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

}
