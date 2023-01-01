package com.apirestful.apirestful.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirestful.apirestful.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}
