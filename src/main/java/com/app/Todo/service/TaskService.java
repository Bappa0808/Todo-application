package com.app.Todo.service;

import com.app.Todo.models.Task;
import com.app.Todo.repositary.taskRepositary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final taskRepositary taskRepositary;

    public TaskService(com.app.Todo.repositary.taskRepositary taskRepositary) {
        this.taskRepositary = taskRepositary;
    }

    public List<Task> getAllTask() {
        return taskRepositary.findAll();
    }

    public void createTask(String title) {
        Task task =new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepositary.save(task);

    }

    public void deleteTask(Long id) {
        taskRepositary.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task;
        task = taskRepositary.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid task id"));
        task.setCompleted(!task.isCompleted());
        taskRepositary.save(task);

    }
}
