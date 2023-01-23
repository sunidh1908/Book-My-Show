package com.example.BookMyShowStructure.Repository;

import com.example.BookMyShowStructure.Model.TheaterSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface TheaterSeatsRepository extends JpaRepository<TheaterSeatsEntity, Integer> {
}
