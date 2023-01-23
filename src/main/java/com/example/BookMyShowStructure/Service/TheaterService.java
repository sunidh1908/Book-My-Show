package com.example.BookMyShowStructure.Service;

import com.example.BookMyShowStructure.dto.EntryDto.TheaterEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.TheaterResponseDto;

public interface TheaterService {

    TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto);

    TheaterResponseDto getTheater(int id);

}
