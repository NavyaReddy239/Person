package com.example.Person.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.example.Person.model.PersonDto;
import com.example.Person.model.PersonVo;



@Mapper(componentModel = "Spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface PersonMapper {


	public PersonDto toPersonDto(PersonVo person);

	public PersonVo toPersonVo(PersonDto savePersonDto);

	public List<PersonVo> toPersonVos(List<PersonDto> personDto);

	List<PersonDto> toPersonDtos(List<PersonVo> list);
}

