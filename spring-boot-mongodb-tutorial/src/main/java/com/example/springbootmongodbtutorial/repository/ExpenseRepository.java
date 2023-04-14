package com.example.springbootmongodbtutorial.repository;

import com.example.springbootmongodbtutorial.modal.Expense;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

  @Query("{'name': ?0}")
  Optional<Expense> findByName(String name);
}
