package com.example.BookMyShowStructure.Repository;

import com.example.BookMyShowStructure.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}