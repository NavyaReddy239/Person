package com.example.Person.dao;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.example.Person.model.PersonDto;

@Repository

public class PersonDaoImpl implements PersonDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	Logger logger = LoggerFactory.getLogger(PersonDao.class);
	@Override
	public PersonDto savePersonDto(PersonDto personDto) {
		String query = "insert into personVo values('"+personDto.getPersonId()+"','"+personDto.getPersonName()+"')";
		jdbcTemplate.update(query);
		logger.info("Creating");
		return personDto;
	}
	@Override
	public List<PersonDto> getPersonDto() {
		
		String sql = "select*from personVo";
		logger.info("Find all the data");
        List<PersonDto> personDto = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<PersonDto>(PersonDto.class));
        return personDto;
	
	
}
}
