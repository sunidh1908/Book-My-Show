package com.example.BookMyShowStructure.Repository;

import com.example.BookMyShowStructure.Model.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity,Integer> {
}