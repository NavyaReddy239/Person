package com.example.Person.eo;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Person.model.PersonDto;



public interface PersonEo {
	public List<PersonDto> getPersonDto();
	public PersonDto savePersonDto(PersonDto personDto);
	public Object healthcheck();

}
