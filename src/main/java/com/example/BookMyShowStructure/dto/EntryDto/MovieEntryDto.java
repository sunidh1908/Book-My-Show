package com.example.BookMyShowStructure.dto.EntryDto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MovieEntryDto {

    String name;

    @NotNull
    LocalDate releaseDate;
}
