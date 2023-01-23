package com.example.BookMyShowStructure.Service;

import com.example.BookMyShowStructure.dto.EntryDto.UserEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.UserResponseDto;

public interface UserService {

    void addUser(UserEntryDto userEntryDto);

    UserResponseDto getUser(int id);
}
