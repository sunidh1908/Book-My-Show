package com.example.BookMyShowStructure.dto;

import com.example.BookMyShowStructure.dto.ResponseDto.ShowResponseDto;
import com.example.BookMyShowStructure.dto.ResponseDto.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TicketDto {

    int id;

    String alloted_seats;

    double amount;

    ShowResponseDto showDto;

    @NotNull
    UserResponseDto userDto;
}
