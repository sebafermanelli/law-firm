package com.solvd.interfaces;

import com.solvd.exceptions.TaskListEmptyException;
import com.solvd.exceptions.TaskNotFoundException;

public interface TaskManager {
  void addTask(String task);

  void deleteTask(String task) throws TaskListEmptyException, TaskNotFoundException;
}
