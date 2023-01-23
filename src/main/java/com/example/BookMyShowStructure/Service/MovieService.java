package com.example.BookMyShowStructure.Service;

import com.example.BookMyShowStructure.dto.EntryDto.MovieEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShowStructure.dto.ResponseDto.MovieResponseDto;

public interface MovieService {

    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);

    MovieResponseDto getMovie(int id);

    MovieNameAndIdObject getNameAndId(int id);

}
