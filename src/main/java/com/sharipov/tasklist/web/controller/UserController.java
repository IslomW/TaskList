package com.sharipov.tasklist.web.controller;

import com.sharipov.tasklist.domain.task.Task;
import com.sharipov.tasklist.domain.user.User;
import com.sharipov.tasklist.service.TaskService;
import com.sharipov.tasklist.service.UserService;
import com.sharipov.tasklist.web.dto.task.TaskDto;
import com.sharipov.tasklist.web.dto.user.UserDto;
import com.sharipov.tasklist.web.dto.validation.OnCreate;
import com.sharipov.tasklist.web.dto.validation.OnUpdate;
import com.sharipov.tasklist.web.mappers.TaskMapper;
import com.sharipov.tasklist.web.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    private final TaskMapper taskMapper;
    private final UserMapper userMapper;

    @PutMapping
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto dto) {
        User user = userMapper.toEntity(dto);
        User updateUser = userService.update(user);
        return userMapper.toDto(user);

    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id) {
        List<Task> tasks = taskService.getAllById(id);
        return taskMapper.toDto(tasks);
    }

    @PostMapping("/{id}/tasks")
    public TaskDto createTask(@PathVariable Long id,
                              @Validated(OnCreate.class) @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);

    }

}
