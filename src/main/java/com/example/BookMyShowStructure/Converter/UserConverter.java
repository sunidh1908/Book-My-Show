package com.example.BookMyShowStructure.Converter;

import com.example.BookMyShowStructure.Model.UserEntity;
import com.example.BookMyShowStructure.dto.EntryDto.UserEntryDto;
import com.example.BookMyShowStructure.dto.EntryDto.UserEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.UserResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){

        return UserEntity.builder().name(userEntryDto.getName()).mobile(userEntryDto.getMobNo()).build();
    }

    public static UserResponseDto convertEntityToDto(UserEntity user){

        return UserResponseDto.builder().id(user.getId()).name(user.getName())
                .mobNo(user.getMobile()).build();
    }

}
