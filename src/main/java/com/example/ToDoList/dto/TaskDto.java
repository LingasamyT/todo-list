package com.example.ToDoList.dto;

import lombok.Data;

@Data
public class TaskDto {
    private String id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private boolean isActive;
}
