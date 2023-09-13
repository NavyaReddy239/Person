package com.example.Person.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Person.eo.PersonEo;
import com.example.Person.model.HealthCheck;
import com.example.Person.model.PersonDto;
import com.fasterxml.jackson.databind.ObjectMapper;
@AutoConfigureMockMvc
@SpringBootTest
 class PersonBoImplTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private PersonEo personEo;
	
	ObjectMapper obj = new ObjectMapper();
    
	 @Test
	  void saveOrderDtoTest() throws Exception{
          PersonDto personDto=new PersonDto(1,"Sitha");
          String json=obj.writeValueAsString(personDto);
          when(personEo.savePersonDto(any())).thenReturn(personDto);
          mockMvc.perform(post("/persons/post").content(json)
      		    .contentType(MediaType.APPLICATION_JSON_VALUE)
                  .accept(MediaType.APPLICATION_JSON))
                  .andDo(print())
                  .andExpect(status().isOk());
	    }
	    @Test
	     void getPersonDtoTest() throws Exception{
	         List<PersonDto> listPersonDto=new ArrayList<>();
	         PersonDto personDto=new PersonDto();
	         personDto.setPersonId(1);
	         personDto.setPersonName("Sitha");
	         PersonDto personDto1=new PersonDto();
	         personDto1.setPersonId(2);
	         personDto1.setPersonName("Githa");
	         listPersonDto.add(personDto);
	         listPersonDto.add(personDto1);
	         when(personEo.getPersonDto()).thenReturn(listPersonDto);
	          mockMvc.perform(get("/persons/get"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$", hasSize(2)));
	    }
	   @Test
	       public void healthCheck()  throws Exception{
	    	   HealthCheck healthCheck=new HealthCheck("Check table is available in db","Success","Table is available");
	    	   String json=obj.writeValueAsString(healthCheck);
	    	   when(personEo.healthcheck()).thenReturn(healthCheck);
	    	   mockMvc.perform(get("/persons/healthcheck").content(json)
	       		    .contentType(MediaType.APPLICATION_JSON_VALUE)
	                   .accept(MediaType.APPLICATION_JSON))
	                   .andDo(print())
	                   .andExpect(status().isOk());
	       }
}
