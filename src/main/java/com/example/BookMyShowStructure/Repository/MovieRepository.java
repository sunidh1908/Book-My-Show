package com.example.BookMyShowStructure.Repository;

import com.example.BookMyShowStructure.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

    boolean existsByName(String name);
}
