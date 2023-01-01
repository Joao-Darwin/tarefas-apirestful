package com.apirestful.apirestful.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirestful.apirestful.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
