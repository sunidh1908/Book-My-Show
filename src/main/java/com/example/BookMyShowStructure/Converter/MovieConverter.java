package com.example.BookMyShowStructure.Converter;

import com.example.BookMyShowStructure.Model.MovieEntity;
import com.example.BookMyShowStructure.dto.EntryDto.MovieEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShowStructure.dto.ResponseDto.MovieResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {

    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto){

        return MovieEntity.builder()
                .name(movieEntryDto.getName())
                .releaseDate(movieEntryDto.getReleaseDate()).build();
    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movieEntity){

        return MovieResponseDto.builder().id(movieEntity.getId()).releaseDate(movieEntity.getReleaseDate()).
                name(movieEntity.getName()).build();
    }

    public static MovieNameAndIdObject convertEntityToThisObject(MovieEntity movieEntity){

        return MovieNameAndIdObject.builder().
                id(movieEntity.getId())
                .name(movieEntity.getName()).build();
    }
}
