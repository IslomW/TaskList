package com.sharipov.tasklist.service.impl;

import com.sharipov.tasklist.domain.task.Task;
import com.sharipov.tasklist.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public Task getById(Long id) {
        return null;
    }

    @Override
    public List<Task> getAllById(Long userId) {
        return null;
    }

    @Override
    public void assignToUserById(Long taskId, Long userId) {

    }

    @Override
    public Task update(Task task) {

        return task;
    }

    @Override
    public Task create(Task task, Long id) {

        return task;
    }

    @Override
    public void delete(Long id) {

    }
}
