package com.example.Person.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonDto {
	
	private int personId;

	private String personName;

	public PersonDto() {
		super();
	}
	public PersonDto(int personId, String personName) {
		super();
		this.personId = personId;
		this.personName = personName;
		
	}

	@XmlElement
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	@XmlElement
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	}



