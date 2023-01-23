package com.example.BookMyShowStructure.dto.ResponseDto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MovieResponseDto {

    @NotNull
    int id;
    String name;
    LocalDate releaseDate;

    List<ShowResponseDto> showDtoList;
}
