package com.app.Todo.repositary;

import com.app.Todo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface taskRepositary extends JpaRepository<Task,Long> {
}
