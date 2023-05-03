package com.subodh.springbooot.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.subodh.springbooot.entity.RegisterEntity;

@Service
public class MysqlServiceImpl implements MysqlService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    @Override
	public List<RegisterEntity> getAllRegisterRecords() {
		String sqlQuery = "select * from register_info";
		
		List<RegisterEntity> list = 
	  jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper(RegisterEntity.class));
		
		/*
		 * List<Map<String,Object>> registerList = jdbcTemplate.queryForList(sqlQuery);
		 * 
		 * for(Map<String,Object> map:registerList) { System.out.println(map); }
		 * List<RegisterEntity>list = registerList.stream().map(data->{ RegisterEntity
		 * register = new RegisterEntity();
		 * register.setId(Long.parseLong(data.get("id").toString()));
		 * register.setCity(data.get("city").toString());
		 * register.setNumber(data.get("number").toString());
		 * register.setEmail(data.get("email").toString());
		 * register.setName(data.get("name").toString());
		 * register.setCountry(data.get("country").toString());
		 * register.setGender(data.get("gender").toString());
		 * register.setPincode(data.get("pincode").toString());
		 * 
		 * return register; }).collect(Collectors.toList());
		 */
		
		return list;
	}
}
