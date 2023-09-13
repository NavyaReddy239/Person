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
    logger.info("Save person");
    return personDao.savePersonDto(personDto);
//    try {
//       //  Create a JAXBContext for PersonDto
//        JAXBContext context = JAXBContext.newInstance(PersonDto.class);
//        // Marshalling (Java object to XML)
//        Marshaller marshaller = context.createMarshaller();
//        StringWriter writer = new StringWriter();
//        marshaller.marshal(personDto, writer);
//        String xml = writer.toString();
//        // Unmarshalling (XML to Java object)
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        PersonDto unmarshalledPersonDto = (PersonDto) unmarshaller.unmarshal(new StringReader(xml));
//        // Save the unmarshalledPersonDto to the database
//        PersonDto savedPersonDto = personDao.savePersonDto(unmarshalledPersonDto);
//        return savedPersonDto;
//
//    } catch (JAXBException e) {
//        logger.error("Error while marshalling/unmarshalling PersonDto: " + e.getMessage());
//        return null; // Or throw an exception
//    }
    }
@Override
public Object healthcheck() {
	// TODO Auto-generated method stub
	return null;
}

}


