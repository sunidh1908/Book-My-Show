package com.example.BookMyShowStructure.Controller;

import com.example.BookMyShowStructure.Service.impl.MovieServiceImpl;
import com.example.BookMyShowStructure.dto.EntryDto.MovieEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShowStructure.dto.ResponseDto.MovieResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("movie")
public class MovieController {


    @Autowired
    MovieServiceImpl movieService;


    @PostMapping("/add")
    public MovieResponseDto addMovie(@RequestBody() MovieEntryDto movieEntryDto){

        MovieResponseDto movieResponseDto = movieService.addMovie(movieEntryDto);
        log.info("The movieResponseDto is ",movieResponseDto);
        return movieResponseDto;

    }

    @GetMapping("/get/{id}")
    public MovieNameAndIdObject getNameAndId(@PathVariable Integer id){

        MovieNameAndIdObject movieNameAndIdObject = movieService.getNameAndId(id);
        return movieNameAndIdObject;
    }

}
