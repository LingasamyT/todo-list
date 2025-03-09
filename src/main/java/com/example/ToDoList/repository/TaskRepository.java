package com.example.ToDoList.repository;

import com.example.ToDoList.model.TaskModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<TaskModel,String> {
    @Query(value = "{'isActive':true}")
    List<TaskModel> findAllIsActive();
}
