package com.example.BookMyShowStructure.Service.impl;

import com.example.BookMyShowStructure.Model.UserEntity;
import com.example.BookMyShowStructure.Repository.UserRepository;
import com.example.BookMyShowStructure.Service.UserService;
import com.example.BookMyShowStructure.Converter.UserConverter;
import com.example.BookMyShowStructure.dto.EntryDto.UserEntryDto;
import com.example.BookMyShowStructure.dto.EntryDto.UserEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserEntryDto userEntryDto) {

        UserEntity userEntity = UserConverter.convertDtoToEntity(userEntryDto); //Cleaner
        userRepository.save(userEntity);
    }

    @Override
    public UserResponseDto getUser(int id) {

        UserEntity user = new UserEntity();

        UserEntity userEntity = userRepository.findById(id).get();

        UserResponseDto userResponseDto = UserConverter.convertEntityToDto(userEntity);

        return userResponseDto;
    }
}
