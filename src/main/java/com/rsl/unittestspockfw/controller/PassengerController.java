package com.rsl.unittestspockfw.controller;

import com.rsl.unittestspockfw.dto.PassengerReqDto;
import com.rsl.unittestspockfw.dto.PassengerRespDto;
import com.rsl.unittestspockfw.service.PassengerServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/passenger-V2")
public class PassengerController {

    private final PassengerServiceV2 service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassengerRespDto add(@RequestBody PassengerReqDto passengerReqDto){
        return service.add(passengerReqDto);
    }

    @PutMapping("/{id}")
    public PassengerRespDto update(@PathVariable Integer id, @RequestBody PassengerReqDto passengerReqDto){
        return service.update(id, passengerReqDto);
    }

    @GetMapping
    public List<PassengerRespDto> get(){
        return service.get();
    }

    @GetMapping("/{id}")
    public PassengerRespDto getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
