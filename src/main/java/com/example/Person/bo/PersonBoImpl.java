package com.example.Person.bo;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Person.bo.PersonBoImpl;
import com.example.Person.eo.PersonEo;
import com.example.Person.execption.ResourceNotFoundException;
import com.example.Person.model.HealthCheck;
import com.example.Person.model.PersonDto;

@Service

public class PersonBoImpl implements PersonBo {
	@Autowired
	private PersonEo personEo;
	Logger logger = LoggerFactory.getLogger(PersonBoImpl.class);

	public PersonBoImpl(PersonEo personEo2) {

	}

	@Override
	public List<PersonDto> getPersonDto() {
		logger.info("retrieving person details");
		return personEo.getPersonDto();
	}

	@Override
	public PersonDto savePersonDto(PersonDto personDto) {
		logger.info("saving the person details");
		return personEo.savePersonDto(personDto);
	}

	@Override
	public HealthCheck healthcheck() {
		HealthCheck healthcheck = new HealthCheck();
		healthcheck.setHealthComment("Checking for table in databse");

		try {
			if (getPersonDto() != null) {
				healthcheck.setHealthStatus("success");
				healthcheck.setHealthDescription("table found");
			} else {
				throw new ResourceNotFoundException("table not present");
			}
		} catch (Exception ex) {
			healthcheck.setHealthStatus("failure");
			healthcheck.setHealthDescription("error when checking for table");
		}

		return healthcheck;
	}
}
