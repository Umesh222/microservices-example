package com.umesh.microservices.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umesh.microservices.example.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
