package com.todo.Todo_App.sevices;

import com.todo.Todo_App.models.Task;
import com.todo.Todo_App.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}


	public Task addTasks(Task title) {
		return taskRepository.save(title);
	}

	public void deleteTodo(Long id) {
			taskRepository.deleteById(id);
	}
	public Task updateTodo(Long id, Task updatedTodo) {
		Task task = getTaskById(id);
		task.setTitle(updatedTodo.getTitle());
		task.setCompleted(updatedTodo.isCompleted());
		return taskRepository.save(task);
	}

	private Task getTaskById(Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));


	}


}
