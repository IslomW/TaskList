package com.sharipov.tasklist.service;

import com.sharipov.tasklist.domain.task.Task;

import java.util.List;

public interface TaskService {
    Task getById(Long id);

    List<Task> getAllById(Long userId);

    void assignToUserById(Long taskId, Long userId);

    Task update(Task task);

    Task create(Task task, Long id);

    void delete(Long id);

}
