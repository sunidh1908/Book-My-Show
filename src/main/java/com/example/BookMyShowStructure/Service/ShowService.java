package com.example.BookMyShowStructure.Service;

import com.example.BookMyShowStructure.dto.EntryDto.ShowEntryDto;
import com.example.BookMyShowStructure.dto.ResponseDto.ShowResponseDto;

public interface ShowService {

    ShowResponseDto addShow(ShowEntryDto showEntryDto);

}
