package com.example.BookMyShowStructure.Repository;

import com.example.BookMyShowStructure.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}