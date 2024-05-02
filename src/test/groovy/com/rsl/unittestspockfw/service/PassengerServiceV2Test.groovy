package com.rsl.unittestspockfw.service

import com.rsl.unittestspockfw.dto.PassengerReqDto
import com.rsl.unittestspockfw.dto.PassengerRespDto
import com.rsl.unittestspockfw.entity.Passenger
import com.rsl.unittestspockfw.mapper.PassengerMapper
import com.rsl.unittestspockfw.repository.PassengerRepository
import spock.lang.Specification
import org.jeasy.random.EasyRandom;

class PassengerServiceV2Test extends Specification {
    private PassengerServiceV2 passengerServiceV2
    private PassengerRepository passengerRepository
    private PassengerMapper passengerMapper
    private EasyRandom random = new EasyRandom()
    void setup() {
        passengerRepository = Mock()
        passengerMapper = Mock()
        passengerServiceV2 = new PassengerServiceV2(passengerRepository, passengerMapper)
    }

    def "GetById"() {
        given:
        def id = 1
        def passengerEntity = random.nextObject(Passenger)

        def passengerRespDto = random.nextObject(PassengerRespDto)


        when:
        def result = passengerServiceV2.getById(id)

        then:
        1 * passengerRepository.findById(id) >> Optional.of(passengerEntity)
        1 * passengerMapper.toDto(passengerEntity) >> passengerRespDto

        result == passengerRespDto
    }


    def "Update"() {
        given:
        def id = 1
        def reqDto = new PassengerReqDto(name: "Name", surname: "Surname", status: 1)
        def respDto = new PassengerRespDto(id: id, fullName: "Name Surname", status: 1)

        when:
        def result = passengerServiceV2.update(id, reqDto)

        then:
        1 * passengerMapper.toEntity(reqDto) >> new Passenger(name: "Name", surname: "Surname", status: 1)
        1 * passengerRepository.save(_ as Passenger) >> new Passenger(id: id, name: "Name", surname: "Surname", status: 1)

        1 * passengerMapper.toDto(_ as Passenger) >> respDto

        result == respDto
    }
}
