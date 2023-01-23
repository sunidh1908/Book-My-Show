package com.example.BookMyShowStructure.dto.ResponseDto;

import com.example.BookMyShowStructure.dto.TicketDto;
import lombok.*;

import java.util.List;

@Data
@Builder
public class UserResponseDto {

    int id;

    String name;

    String mobNo;

    List<TicketDto> tickets;
}
