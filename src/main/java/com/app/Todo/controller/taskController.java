package com.app.Todo.controller;

import org.springframework.ui.Model;
import com.app.Todo.models.Task;
import com.app.Todo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class taskController {

    private final TaskService taskService;

    public taskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public String getTask(Model model){
        List<Task> tasks=taskService.getAllTask();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
