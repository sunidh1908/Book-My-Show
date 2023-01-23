package com.example.BookMyShowStructure.Converter;

import com.example.BookMyShowStructure.Model.ShowEntity;
import com.example.BookMyShowStructure.dto.EntryDto.ShowEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.ShowResponseDto;

public class ShowConverter {


    public static ShowEntity convertDtoToEntity(ShowEntryDto showDto){

        return ShowEntity.builder().showDate(showDto.getShowDate()).showTime(showDto.getShowTime())
                .build();
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity, ShowEntryDto showEntryDto){

        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showTime(showEntity.getShowTime())
                .showDate(showEntity.getShowDate())
                .movieResponseDto(showEntryDto.getMovieResponseDto())
                .theaterDto(showEntryDto.getTheaterResponseDto())
                .build();
    }
}