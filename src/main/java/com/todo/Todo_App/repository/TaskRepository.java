package com.todo.Todo_App.repository;

import com.todo.Todo_App.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
	
}
