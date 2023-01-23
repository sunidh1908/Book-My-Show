package com.example.BookMyShowStructure.Controller;

import com.example.BookMyShowStructure.Service.impl.UserServiceImpl;
import com.example.BookMyShowStructure.dto.EntryDto.UserEntryDto;
import com.example.BookMyShowStructure.dto.EntryDto.UserEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserEntryDto userEntryDto){

        userService.addUser(userEntryDto);
        return new ResponseEntity("Added a success User", HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable(value = "id")int id){

        UserResponseDto userResponseDto = userService.getUser(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

}
