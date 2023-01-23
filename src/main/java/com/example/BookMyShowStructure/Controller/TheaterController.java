package com.example.BookMyShowStructure.Controller;

import com.example.BookMyShowStructure.Service.impl.TheaterServiceImpl;
import com.example.BookMyShowStructure.dto.EntryDto.TheaterEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.TheaterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    TheaterServiceImpl theaterService;

    @PostMapping("add")
    public TheaterResponseDto addTheater(@RequestBody() TheaterEntryDto theaterEntryDto){
        return theaterService.addTheater(theaterEntryDto);
    }

}