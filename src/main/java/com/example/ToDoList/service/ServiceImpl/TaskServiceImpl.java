package com.example.ToDoList.service.ServiceImpl;

import com.example.ToDoList.dto.TaskDto;
import com.example.ToDoList.model.TaskModel;
import com.example.ToDoList.repository.TaskRepository;
import com.example.ToDoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public String createTask(TaskDto taskDto) {
        TaskModel taskModel=new TaskModel();
        taskModel.setName(taskDto.getName());
        taskModel.setActive(true);
        taskModel.setDescription(taskDto.getDescription());
        taskModel.setStartDate(taskDto.getStartDate());
        taskModel.setEndDate(taskDto.getEndDate());
        taskRepository.save(taskModel);
        return "Task Added Successfully";
    }

    @Override
    public String DeleteTask(String id) {
        Optional<TaskModel>existingTask=taskRepository.findById(id);
        if (existingTask.isEmpty()){
            throw new RuntimeException("Task not found");
        }
        TaskModel taskModel=existingTask.get();
        taskModel.setActive(false);
        taskRepository.save(taskModel);
        return "Task Deleted Successfully";
    }

    @Override
    public String updateTask(TaskDto taskDto) {
        TaskModel taskModel=taskRepository.findById(taskDto.getId())
                .orElseThrow(()-> new RuntimeException("Id not Found"));
        taskModel.setName(taskDto.getName());
        taskModel.setDescription(taskDto.getDescription());
        taskModel.setStartDate(taskDto.getStartDate());
        taskModel.setEndDate(taskDto.getEndDate());
        taskRepository.save(taskModel);
        return "Task Updated Successfully ";
    }

    @Override
    public Object getTaskById(String id) {
        TaskModel taskModel=taskRepository.findById(id).orElseThrow(()->new RuntimeException("Id Not Found"));
        TaskDto taskDto=new TaskDto();
        taskDto.setId(taskModel.getId());
        taskDto.setName(taskModel.getName());
        taskDto.setDescription(taskModel.getDescription());
        taskDto.setStartDate(taskModel.getStartDate());
        taskDto.setEndDate(taskModel.getEndDate());

        return taskDto;
    }

    @Override
    public List<TaskDto> getAllTask() {
        List<TaskModel> taskModels=taskRepository.findAllIsActive();
        List<TaskDto> taskDtos=new ArrayList<>();
        for(TaskModel taskModel: taskModels)
        {
            TaskDto taskDto=new TaskDto();
            taskDto.setId(taskModel.getId());
            taskDto.setName(taskModel.getName());
            taskDto.setActive(taskModel.isActive());
            taskDto.setDescription(taskModel.getDescription());
            taskDto.setStartDate(taskModel.getStartDate());
            taskDto.setEndDate(taskModel.getEndDate());
            taskDtos.add(taskDto);
        }
        return taskDtos;
    }
}
