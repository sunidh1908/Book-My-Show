package com.example.BookMyShowStructure.Repository;

import com.example.BookMyShowStructure.Model.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
}
