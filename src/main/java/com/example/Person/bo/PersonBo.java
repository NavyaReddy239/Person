package com.example.Person.bo;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Person.model.HealthCheck;
import com.example.Person.model.PersonDto;


public interface PersonBo {
	public List<PersonDto> getPersonDto();
	public PersonDto savePersonDto(PersonDto personDto);
public HealthCheck healthcheck();
}
