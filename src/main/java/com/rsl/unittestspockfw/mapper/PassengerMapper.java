package com.rsl.unittestspockfw.mapper;

import com.rsl.unittestspockfw.dto.PassengerReqDto;
import com.rsl.unittestspockfw.dto.PassengerRespDto;
import com.rsl.unittestspockfw.entity.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PassengerMapper {

    PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);

    @Mapping(target = "fullName", expression = "java(passenger.getName() + \" \" + passenger.getSurname())")
    PassengerRespDto toDto(Passenger passenger);

    Passenger toEntity(PassengerReqDto passengerReqDto);
}

