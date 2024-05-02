package com.rsl.unittestspockfw.service;


import com.rsl.unittestspockfw.dto.PassengerReqDto;
import com.rsl.unittestspockfw.dto.PassengerRespDto;
import com.rsl.unittestspockfw.entity.Passenger;
import com.rsl.unittestspockfw.mapper.PassengerMapper;
import com.rsl.unittestspockfw.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PassengerServiceV2 {

    private final PassengerRepository passengerRepository;

    private final PassengerMapper passengerMapper;

    public PassengerRespDto add(PassengerReqDto reqDto) {
        Passenger passenger = passengerMapper.toEntity(reqDto);
        passenger = passengerRepository.save(passenger);
        return passengerMapper.toDto(passenger);
    }

    public PassengerRespDto update(Integer id, PassengerReqDto reqDto) {
        Passenger passenger = passengerMapper.toEntity(reqDto);
        passenger.setId(id);
        passenger = passengerRepository.save(passenger);
        return passengerMapper.toDto(passenger);
    }

    public void delete(Integer id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        passengerRepository.delete(passenger);
    }

    public List<PassengerRespDto> get() {
        return passengerRepository.findAll()
                .stream()
                .map(passengerMapper::toDto)
                .collect(Collectors.toList());
    }

    public PassengerRespDto getById(Integer id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found"));
        return passengerMapper.toDto(passenger);
    }
}
