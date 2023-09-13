package com.example.Person.controller;




import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.Person.model.HealthCheck;
import com.example.Person.model.PersonVo;
import com.example.Person.service.PersonService;
import com.example.Person.service.PersonServiceImpl;



@RestController
@RequestMapping("/persons")
@Validated

public class PersonController {
@Autowired PersonService personService;
	Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	@GetMapping("/get")
	public ResponseEntity<List<PersonVo>> getPersonVo() {
	    List<PersonVo> personVo = personService.getPersonVo();
	    logger.info("Data of person details is retrieving");
	    return ResponseEntity.ok(personVo);
	}
//	@PostMapping(value="/post",produces="application/json")
//	public ResponseEntity<PersonVo> saveOrderVo(@Validated @RequestBody PersonVo personVo){
//		PersonVo personVos=personService.savePersonVo(personVo);
//		if(personVos==null)
//			return new ResponseEntity("Insertion Error", HttpStatus.BAD_REQUEST);
//		logger.info("Data is saving");
//		return ResponseEntity.status(HttpStatus.OK).body(personVos);
//	}
	
	
	@PostMapping(value="/post",produces="application/json")
	public ResponseEntity<PersonVo> saveOrderVo(@Validated @RequestBody PersonVo personVo){
		PersonVo personVos=personService.savePersonVo(personVo);
		if(personVos!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(personVos);
		} else {
			return new ResponseEntity("Insertion Error", HttpStatus.BAD_REQUEST);		}
			
		//logger.info("Data is saving");
		
	}
	@GetMapping("/healthcheck")
	public ResponseEntity<HealthCheck> healthcheck(){
		HealthCheck healthcheck= personService.healthcheck();
		logger.info("Data is saving in db");
		return ResponseEntity.status(HttpStatus.OK).body(healthcheck);
	}	
    
}

