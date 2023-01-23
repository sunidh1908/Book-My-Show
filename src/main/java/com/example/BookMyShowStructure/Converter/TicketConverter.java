package com.example.BookMyShowStructure.Converter;

import com.example.BookMyShowStructure.Model.TicketEntity;
import com.example.BookMyShowStructure.dto.ResponseDto.TicketResponseDto;

public class TicketConverter {

    public static TicketResponseDto convertEntityToDto(TicketEntity ticketEntity){

        return TicketResponseDto.builder().id((int) ticketEntity.getId())
                .amount(ticketEntity.getAmount())
                .alloted_seats(ticketEntity.getAllottedSeats())
                .build();
    }
}
