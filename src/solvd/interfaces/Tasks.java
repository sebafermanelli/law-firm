package solvd.interfaces;

import solvd.classes.LegalPerson;
import solvd.exceptions.TaskNotFoundException;

public interface Tasks {
  void addTask(String task);

  void deleteTask(int indexTask) throws TaskNotFoundException;
}
