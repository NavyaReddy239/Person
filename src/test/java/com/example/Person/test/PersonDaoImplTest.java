package com.example.Person.test;
import org.springframework.context.annotation.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.example.Person.PersonApplication;
import com.example.Person.dao.PersonDao;
import com.example.Person.model.PersonDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Import;
@SpringBootTest(classes = PersonApplication.class)
@AutoConfigureMockMvc

class PersonDaoImplTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	JdbcTemplate jdbcTemplate;
	 

	
	ObjectMapper obj = new ObjectMapper();
    
	 @Test
	  void savePersonDto() throws Exception{
		 PersonDto personDto=new PersonDto(1,"Sitha");
           String json=obj.writeValueAsString(personDto);
           when(jdbcTemplate.update("insert into personVo values('"+personDto.getPersonId()+"','"+personDto.getPersonName()+"')")).thenReturn(1);
           mockMvc.perform(post("/persons/post")
        		   .content(json)
        		   .contentType(MediaType.APPLICATION_JSON_VALUE)
                   .accept(MediaType.APPLICATION_JSON))
                   .andDo(print())
                     .andExpect(status().isOk());
           
	    }
	 @Test
    void getPersonDto() throws Exception{
		 List<PersonDto> listPersonDto =new ArrayList<>();
		 PersonDto personDto=new PersonDto();
		 personDto.setPersonId(1);
		 personDto.setPersonName("Sitha");
         PersonDto personDto1=new PersonDto();
         personDto1.setPersonId(2);
         personDto1.setPersonName("Githa");
         listPersonDto.add(personDto);
         listPersonDto.add(personDto1);
           String sql = "select*from personVo";
         when(jdbcTemplate.query(sql,
                  new BeanPropertyRowMapper<PersonDto>(PersonDto.class))).thenReturn(listPersonDto);
         mockMvc.perform(get("/persons/get")
        		  .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk());     
	    }
}
