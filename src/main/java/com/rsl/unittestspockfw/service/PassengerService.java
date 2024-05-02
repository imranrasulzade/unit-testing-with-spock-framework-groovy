//package com.rsl.unittestspockfw.service;
//
//import com.rsl.unittestspockfw.dto.PassengerReqDto;
//import com.rsl.unittestspockfw.dto.PassengerRespDto;
//import com.rsl.unittestspockfw.entity.Passenger;
//import com.rsl.unittestspockfw.repository.PassengerRepository;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.MappingException;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.PropertyMap;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class PassengerService {
//
//    private final PassengerRepository passengerRepository;
////    private final ModelMapper modelMapper;
//
//
////    public PassengerRespDto add(PassengerReqDto reqDto) {
////        ModelMapper modelMapper = new ModelMapper();
////        Passenger passenger = new Passenger();
////        modelMapper.map(reqDto, passenger);
////        passenger = passengerRepository.save(passenger);
////        PropertyMap<Passenger, PassengerRespDto> fullNameMap = new PropertyMap<>() {
////            protected void configure() {
////                map().setFullName(source.getName() + " " + source.getSurname());
////            }
////        };
////        modelMapper.addMappings(fullNameMap);
////        PassengerRespDto passengerRespDto = modelMapper.map(passenger, PassengerRespDto.class);
////        return passengerRespDto;
////    }
//
//
//    public PassengerRespDto add(PassengerReqDto reqDto) {
//        ModelMapper modelMapper = new ModelMapper();
//        Passenger passenger = new Passenger();
//        modelMapper.map(reqDto, passenger);
//        passenger = passengerRepository.save(passenger);
//
//        // ModelMapper örneği oluşturulduktan sonra PropertyMap'i tanımla
//        PropertyMap<Passenger, PassengerRespDto> fullNameMap = new PropertyMap<>() {
//            protected void configure() {
//                map().setFullName(source.getName() + " " + source.getSurname());
//            }
//        };
//        modelMapper.addMappings(fullNameMap);
//
//        // Dönüştürme sırasında hata izlemesi yap
//        try {
//            PassengerRespDto passengerRespDto = modelMapper.map(passenger, PassengerRespDto.class);
//            return passengerRespDto;
//        } catch (MappingException ex) {
//            ex.printStackTrace();
//            // Hata durumunda null veya başka bir hata durumu döndürebilirsiniz.
//            return null;
//        }
//    }
//    public PassengerRespDto update(Integer id, PassengerReqDto reqDto) {
//        ModelMapper modelMapper = new ModelMapper();
//        Passenger passenger = new Passenger();
//        modelMapper.map(reqDto, passenger);
//        passenger.setId(id);
//        passenger = passengerRepository.save(passenger);
//        PassengerRespDto passengerRespDto = new PassengerRespDto();
//        PropertyMap<Passenger, PassengerRespDto> fullNameMap = new PropertyMap<>() {
//            protected void configure() {
//                map().setFullName(source.getName() + " " + source.getSurname());
//            }
//        };
//        modelMapper.addMappings(fullNameMap);
//        modelMapper.map(passenger, passengerRespDto);
//        return passengerRespDto;
//    }
//
//    public void delete(Integer id) {
//        Passenger passenger = passengerRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("passenger not found"));
//        passengerRepository.delete(passenger);
//    }
//
//    public List<PassengerRespDto> get() {
//        ModelMapper modelMapper = new ModelMapper();
//        List<PassengerRespDto> passengerRespDtoList = new ArrayList<>();
//        passengerRepository.findAll().forEach((pass) -> {
//            PassengerRespDto passengerRespDto = new PassengerRespDto();
//            PropertyMap<Passenger, PassengerRespDto> fullNameMap = new PropertyMap<>() {
//                protected void configure() {
//                    map().setFullName(source.getName() + " " + source.getSurname());
//                }
//            };
//            modelMapper.addMappings(fullNameMap);
//            modelMapper.map(pass, passengerRespDto);
//            passengerRespDtoList.add(passengerRespDto);
//        });
//        return passengerRespDtoList;
//    }
//
//    public PassengerRespDto getById(Integer id) {
//        ModelMapper modelMapper = new ModelMapper();
//        PassengerRespDto passengerRespDto = new PassengerRespDto();
//        Passenger passenger = passengerRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("passenger not found"));
//        PropertyMap<Passenger, PassengerRespDto> fullNameMap = new PropertyMap<>() {
//            protected void configure() {
//                map().setFullName(source.getName() + " " + source.getSurname());
//            }
//        };
//        modelMapper.addMappings(fullNameMap);
//        modelMapper.map(passenger, passengerRespDto);
//        return passengerRespDto;
//    }
//
//
//
//
//}
