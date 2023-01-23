package com.example.BookMyShowStructure.Service.impl;

import com.example.BookMyShowStructure.Model.TheaterEntity;
import com.example.BookMyShowStructure.Model.TheaterSeatsEntity;
import com.example.BookMyShowStructure.Repository.TheaterRepository;
import com.example.BookMyShowStructure.Repository.TheaterSeatsRepository;
import com.example.BookMyShowStructure.Service.TheaterService;
import com.example.BookMyShowStructure.Converter.TheaterConverter;
import com.example.BookMyShowStructure.dto.EntryDto.TheaterEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.TheaterResponseDto;
import com.example.BookMyShowStructure.enums.SeatType;
import com.example.BookMyShowStructure.enums.TheaterType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatsRepository theaterSeatsRepository;

    @Override
    public TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto) {

        TheaterEntity theaterEntity = TheaterConverter.convertDtoToEntity(theaterEntryDto);

        List<TheaterSeatsEntity> seats = createTheaterSeats();

        theaterEntity.setSeats(seats);

        theaterEntity.setShows(null);

        for(TheaterSeatsEntity theaterSeatsEntity : seats){
            theaterSeatsEntity.setTheater(theaterEntity);
        }

        theaterEntity.setType(TheaterType.SINGLE);

        log.info("The theater entity is "+ theaterEntity);

        theaterEntity = theaterRepository.save(theaterEntity);

        theaterSeatsRepository.saveAll(seats);

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);

        return theaterResponseDto;

    }

    List<TheaterSeatsEntity> createTheaterSeats(){

        List<TheaterSeatsEntity> seats = new ArrayList<>();

        seats.add(getTheaterSeat("1A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1B",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1C",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1D",100,SeatType.CLASSIC));
        seats.add(getTheaterSeat("1E",100,SeatType.CLASSIC));

        seats.add(getTheaterSeat("2A",200,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2B",200,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2C",200,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2D",200,SeatType.PREMIUM));
        seats.add(getTheaterSeat("2E",200,SeatType.PREMIUM));

        return seats;

    }

    TheaterSeatsEntity getTheaterSeat(String seatName, int rate, SeatType seatType){

        return TheaterSeatsEntity.builder().seatNumber(seatName).rate(rate).seatType(seatType).build();
    }


    @Override
    public TheaterResponseDto getTheater(int id) {

        TheaterEntity theaterEntity = theaterRepository.findById(id).get();

        TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);

        return theaterResponseDto;
    }
}
