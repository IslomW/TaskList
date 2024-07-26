package com.sharipov.tasklist.repository.mapper;

import com.sharipov.tasklist.domain.task.Task;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Optional<Task> findById(Long id);

    List<Task> findAllById(Long userId);

    void assignToUserById(Long taskId, Long userId) throws SQLException;

    void update(Task task);

    void create(Task task);

    void delete(Long id);

}
