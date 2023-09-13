package com.example.Person.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Person.bo.PersonBo;
import com.example.Person.controller.PersonController;
import com.example.Person.dao.PersonDao;

import com.example.Person.execption.ResourceNotFoundException;
import com.example.Person.mapper.PersonMapper;
import com.example.Person.model.HealthCheck;
import com.example.Person.model.PersonDto;
import com.example.Person.model.PersonVo;



@Service
@Component
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonBo personBo;
	@Autowired
	private PersonMapper personMapper;
	Logger logger= LoggerFactory.getLogger(PersonServiceImpl.class);
    @Override
	public List<PersonVo> getPersonVo() {
		logger.info("Retrieving data");
		return personMapper.toPersonVos(personBo.getPersonDto());
	}
	@Override
	public PersonVo savePersonVo(PersonVo person) {
	
		logger.info("Saving Person");
		return personMapper.toPersonVo(personBo.savePersonDto(personMapper.toPersonDto(person)));
	}
	
	@Override
	public HealthCheck healthcheck() {
		logger.info("Healthcheck in progress");
		return personBo.healthcheck();
	}
}


