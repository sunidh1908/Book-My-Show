package com.example.BookMyShowStructure.dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieNameAndIdObject {

    int id;
    String name;
}