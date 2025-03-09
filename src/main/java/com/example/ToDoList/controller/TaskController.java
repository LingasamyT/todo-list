package com.example.ToDoList.controller;

import com.example.ToDoList.dto.TaskDto;
import com.example.ToDoList.service.ServiceImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private  TaskServiceImpl taskService;

    @PostMapping("/task")
    public ResponseEntity<String> createTask(@RequestBody TaskDto taskDto)
    {
        return  ResponseEntity.ok(taskService.createTask(taskDto));
    }

    @DeleteMapping("/deleteTask")
    public ResponseEntity<String> deleteTask(@RequestParam String id)
    {
        return  ResponseEntity.ok(taskService.DeleteTask(id));
    }

    @PutMapping("/updateTask")
    public ResponseEntity<String> updateTask(@RequestBody TaskDto taskDto)
    {
        return  ResponseEntity.ok(taskService.updateTask(taskDto));
    }

    @GetMapping("/getById")
    public ResponseEntity<Object> getTaskById(@RequestParam String id)
    {
        return  ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TaskDto>> getAllTask() {
        return  ResponseEntity.ok(taskService.getAllTask());
    }

}
