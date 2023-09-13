package com.example.Person.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Person.model.HealthCheck;
import com.example.Person.model.PersonVo;


@Service
public interface PersonService {
	 public List<PersonVo> getPersonVo();
	 public PersonVo savePersonVo(PersonVo personVo);
	 public HealthCheck healthcheck();
}

