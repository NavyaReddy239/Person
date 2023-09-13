package com.example.Person.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Person.model.PersonDto;


@Service
@Component
public interface PersonDao {
	public List<PersonDto> getPersonDto();
	public PersonDto savePersonDto(PersonDto personDto);
}

