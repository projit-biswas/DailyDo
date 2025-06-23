package com.todo.Todo_App.controller;

import com.todo.Todo_App.models.Task;
import com.todo.Todo_App.sevices.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {
	private final TaskService taskService;

	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}


	@GetMapping
	public List<Task> getTask(){
		return taskService.getAllTasks();
	}

	@PostMapping("/add")
	public Task addTask(@RequestBody Task title){
		return taskService.addTasks(title);

	}
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskService.deleteTodo(id);
	}

	@PutMapping("/{id}")
	public Task updateTodo(@PathVariable Long id, @RequestBody Task todo) {
		return taskService.updateTodo(id, todo);
	}


}
