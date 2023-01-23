package com.example.BookMyShowStructure.Service.impl;

import com.example.BookMyShowStructure.Model.ShowEntity;
import com.example.BookMyShowStructure.Model.ShowSeatsEntity;
import com.example.BookMyShowStructure.Model.TicketEntity;
import com.example.BookMyShowStructure.Model.UserEntity;
import com.example.BookMyShowStructure.Repository.ShowRepository;
import com.example.BookMyShowStructure.Repository.TicketRepository;
import com.example.BookMyShowStructure.Repository.UserRepository;
import com.example.BookMyShowStructure.Service.TicketService;
import com.example.BookMyShowStructure.Converter.ShowConverter;
import com.example.BookMyShowStructure.Converter.TicketConverter;
import com.example.BookMyShowStructure.Converter.UserConverter;
import com.example.BookMyShowStructure.dto.BookTicketRequestDto;
import com.example.BookMyShowStructure.dto.ResponseDto.TicketResponseDto;
import com.example.BookMyShowStructure.dto.TicketDto;
import com.example.BookMyShowStructure.enums.SeatType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto getTicket(int id) {

        TicketEntity ticketEntity = ticketRepository.findById(id).get();

        UserConverter TicketConvertor;
        TicketResponseDto ticketResponseDto = TicketConverter.convertEntityToDto(ticketEntity);

        return ticketResponseDto;

    }

    @Override
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {


        UserEntity userEntity = userRepository.findById(bookTicketRequestDto.getId()).get();
        ShowEntity showEntity = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        log.info("Ticket half processed");

        Set<String> requestSeats = bookTicketRequestDto.getRequestedSeats();

        List<ShowSeatsEntity> showSeatsEntityList = showEntity.getSeats();

        List<ShowSeatsEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatsEntity seat :showSeatsEntityList){

            if(!seat.isBooked()&&seat.getSeatType().equals(bookTicketRequestDto.getSeatType())
                    &&requestSeats.contains(seat.getSeatNumber())){
                bookedSeats.add(seat);
            }
        }

        for(ShowSeatsEntity seat: bookedSeats) System.out.println(seat);

        if(bookedSeats.size() != requestSeats.size()){
            throw new Error("All Seats not available");
        }

        TicketEntity ticketEntity = TicketEntity.builder().
                user(userEntity)
                .show(showEntity)
                .seats(bookedSeats).
                build();

        double amount = 0;

        for(ShowSeatsEntity showSeatsEntity : bookedSeats){

            showSeatsEntity.setBooked(true);
            showSeatsEntity.setBookedAt(new Date());
            showSeatsEntity.setTicket(ticketEntity);

            amount = amount + showSeatsEntity.getRate();
        }

        ticketEntity.setBookedAt(new Date());
        ticketEntity.setAllottedSeats(convertListOfSeatsEntityToString(bookedSeats));
        ticketEntity.setAmount(amount);

        showEntity.getTickets().add(ticketEntity);

        userEntity.getTicketEntities().add(ticketEntity);

        ticketEntity = ticketRepository.save(ticketEntity);

        ShowConverter TicketConvertor;
        return TicketConverter.convertEntityToDto(ticketEntity);

    }

    public String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats){

        String str = "";
        for(ShowSeatsEntity showSeatsEntity : bookedSeats){
            str = str + showSeatsEntity.getSeatNumber()+" ";
        }
        return str;
    }
}
