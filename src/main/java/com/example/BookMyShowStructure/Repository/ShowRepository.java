package com.example.BookMyShowStructure.Repository;

import com.example.BookMyShowStructure.Model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ShowRepository extends JpaRepository<ShowEntity, Integer> {
}
