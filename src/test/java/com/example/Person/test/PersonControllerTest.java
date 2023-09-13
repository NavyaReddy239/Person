package com.example.Person.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Person.model.HealthCheck;
import com.example.Person.model.PersonVo;
import com.example.Person.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.hasSize;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
@AutoConfigureMockMvc
@SpringBootTest
class PersonControllerTest {

@Autowired
private MockMvc mockMvc;
@MockBean
private PersonService personService;
ObjectMapper obj = new ObjectMapper();

   @Test
    void savePersonVo() throws Exception{
    	PersonVo personVos=new PersonVo(1,"Sitha");
        String json = obj.writeValueAsString(personVos);
        when(personService.savePersonVo(any())).thenReturn(personVos);
        mockMvc.perform(post("/persons/post").content(json)
        		    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk());
        when(personService.savePersonVo(any())).thenReturn(null);
        mockMvc.perform(post("/persons/post").content(json).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON))
		        .andDo(print())
		        .andExpect(status().isBadRequest());
		}
    
   @Test
    void getPersonVo()  throws Exception{
	   List<PersonVo> listPersonVo=new ArrayList<>();
         PersonVo personVo=new PersonVo();
         personVo.setPersonId(1);
         personVo.setPersonName("Sitha");
         
         PersonVo personVo1=new PersonVo();
         personVo1.setPersonId(2);
         personVo1.setPersonName("Githa");
         listPersonVo.add(personVo);
         listPersonVo.add(personVo1);
         when(personService.getPersonVo()).thenReturn(listPersonVo);
         mockMvc.perform(get("/persons/get"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));    
  }
   @Test
   void healthCheck()  throws Exception{
	   HealthCheck healthCheck=new HealthCheck("Check table is available in db","Success","Table is available");
	   String json=obj.writeValueAsString(healthCheck);
	   when( personService.healthcheck()).thenReturn(healthCheck);
	   mockMvc.perform(get("/persons/healthcheck").content(json)
   		    .contentType(MediaType.APPLICATION_JSON_VALUE)
               .accept(MediaType.APPLICATION_JSON))
               .andDo(print())
               .andExpect(status().isOk());
   }
   }
