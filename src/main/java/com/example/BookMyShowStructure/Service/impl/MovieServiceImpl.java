package com.example.BookMyShowStructure.Service.impl;

import com.example.BookMyShowStructure.Model.MovieEntity;
import com.example.BookMyShowStructure.Repository.MovieRepository;
import com.example.BookMyShowStructure.Service.MovieService;
import com.example.BookMyShowStructure.Converter.MovieConverter;
import com.example.BookMyShowStructure.dto.EntryDto.MovieEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShowStructure.dto.ResponseDto.MovieResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto)  {

        MovieResponseDto movieResponseDto = null;

        if(movieRepository.existsByName(movieEntryDto.getName())){

            movieResponseDto.setName("This movie is already Existing");
            return movieResponseDto;
        }

        log.info("In the function add movie "+ movieEntryDto);

        MovieEntity movieEntity = MovieConverter.convertDtoToEntity(movieEntryDto);

        movieEntity = movieRepository.save(movieEntity);

        movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);

        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovie(int id) {

        MovieEntity movieEntity = movieRepository.findById(id).get();

        MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;

    }

    @Override
    public MovieNameAndIdObject getNameAndId(int id){

        MovieEntity movieEntity = movieRepository.findById(id).get();

        MovieNameAndIdObject obj = MovieConverter.convertEntityToThisObject(movieEntity);

        return obj;
    }

}
