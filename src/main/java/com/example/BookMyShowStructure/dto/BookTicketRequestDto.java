package com.example.BookMyShowStructure.dto;

import com.example.BookMyShowStructure.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BookTicketRequestDto {

    int id;
    int showId;
    SeatType seatType;
    Set<String> requestedSeats;
}
