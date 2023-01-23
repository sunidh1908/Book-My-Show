package com.example.BookMyShowStructure.Service;

import com.example.BookMyShowStructure.dto.BookTicketRequestDto;
import com.example.BookMyShowStructure.dto.ResponseDto.TicketResponseDto;
import com.example.BookMyShowStructure.dto.TicketDto;

public interface TicketService {
    TicketResponseDto getTicket(int id);

    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

}
