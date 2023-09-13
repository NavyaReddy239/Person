package com.example.Person.mapper;

import com.example.Person.model.PersonDto;
import com.example.Person.model.PersonVo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-13T13:58:17+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDto toPersonDto(PersonVo person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setPersonId( person.getPersonId() );
        personDto.setPersonName( person.getPersonName() );

        return personDto;
    }

    @Override
    public PersonVo toPersonVo(PersonDto savePersonDto) {
        if ( savePersonDto == null ) {
            return null;
        }

        PersonVo personVo = new PersonVo();

        personVo.setPersonId( savePersonDto.getPersonId() );
        personVo.setPersonName( savePersonDto.getPersonName() );

        return personVo;
    }

    @Override
    public List<PersonVo> toPersonVos(List<PersonDto> personDto) {
        if ( personDto == null ) {
            return null;
        }

        List<PersonVo> list = new ArrayList<PersonVo>( personDto.size() );
        for ( PersonDto personDto1 : personDto ) {
            list.add( toPersonVo( personDto1 ) );
        }

        return list;
    }

    @Override
    public List<PersonDto> toPersonDtos(List<PersonVo> list) {
        if ( list == null ) {
            return null;
        }

        List<PersonDto> list1 = new ArrayList<PersonDto>( list.size() );
        for ( PersonVo personVo : list ) {
            list1.add( toPersonDto( personVo ) );
        }

        return list1;
    }
}
