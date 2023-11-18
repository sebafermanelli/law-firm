package org.solvd.interfaces;

import org.solvd.exceptions.TaskListEmptyException;
import org.solvd.exceptions.TaskNotFoundException;

public interface TaskManager {
  void addTask(String task);

  void deleteTask(String task) throws TaskListEmptyException, TaskNotFoundException;
}
