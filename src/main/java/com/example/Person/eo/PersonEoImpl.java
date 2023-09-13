package com.example.Person.eo;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Person.dao.PersonDao;
import com.example.Person.model.PersonDto;

@Component
@Service
public class PersonEoImpl implements PersonEo {
	@Autowired
	private PersonDao personDao;
	Logger logger = LoggerFactory.getLogger( PersonEo.class);
	@Override
	public List< PersonDto> getPersonDto() {
		logger.info("Retrieving data");
		return personDao.getPersonDto();
	}
@Override
public  PersonDto savePersonDto(PersonDto personDto) {
	logger.info("adding person details");

	 

	try {
		JAXBContext context = JAXBContext.newInstance(PersonDto.class);



		Marshaller marshaller = context.createMarshaller();



		StringWriter writer = new StringWriter();



		marshaller.marshal(personDto, writer);



		String xml = writer.toString();



		Unmarshaller unmarshaller = context.createUnmarshaller();



		PersonDto unmarshalledPersonDto = (PersonDto) unmarshaller.unmarshal(new StringReader(xml));



		PersonDto savePersonDto = personDao.savePersonDto(unmarshalledPersonDto);



		return savePersonDto;



	} catch (JAXBException e) {



		logger.error("Error while marshalling/unmarshalling PersonDto: " + e.getMessage());



		return null;



	}



}
    
@Override
public Object healthcheck() {
	// TODO Auto-generated method stub
	return null;
}

}


