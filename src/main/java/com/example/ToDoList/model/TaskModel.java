package com.example.ToDoList.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Task")
public class TaskModel {
    @Id
    private String id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private boolean isActive;
}
