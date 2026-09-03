package com.brunobarbosa.todolist_api.repository;

import com.brunobarbosa.todolist_api.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
