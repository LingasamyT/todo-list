package com.example.ToDoList.service;

import com.example.ToDoList.dto.TaskDto;

import java.util.List;

public interface TaskService {

    String createTask(TaskDto taskDto);

    String DeleteTask(String id);

    String updateTask(TaskDto taskDto);

    Object getTaskById(String id);

    List<TaskDto> getAllTask();
}
