package com.example.Person.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import jakarta.annotation.Nonnull;
@XmlRootElement
public class PersonVo {
	@Nonnull

	private int personId;
	@Nonnull
	
	private String personName;

	public PersonVo() {
		super();
	}
	public PersonVo(int personId, String personName) {
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
