package com.solvd.classes;

import com.solvd.exceptions.TaskListEmptyException;
import com.solvd.exceptions.TaskNotFoundException;
import com.solvd.interfaces.TaskManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Objects;

public class LegalSecretary extends LegalPerson implements TaskManager {
  private static final Logger LOGGER = LogManager.getLogger(LegalSecretary.class);
  protected ArrayList<String> tasks;

  public LegalSecretary(String name, int experienceYears) {
    super(name, experienceYears);
    this.tasks = new ArrayList<>();
  }

  public ArrayList<String> getTasks() {
    return tasks;
  }

  public void setTasks(ArrayList<String> tasks) {
    this.tasks = tasks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    LegalSecretary that = (LegalSecretary) o;
    return Objects.equals(getTasks(), that.getTasks());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getTasks());
  }

  @Override
  public String toString() {
    return "LegalSecretary{" +
            "tasks=" + tasks +
            ", experienceYears=" + experienceYears +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public void displayPersonInfo() {
    LOGGER.info("Legal Secretary Information: " + toString());
  }

  @Override
  public void addTask(String task) {
    tasks.add(task);
    LOGGER.info("Task added successfully");
  }

  @Override
  public void deleteTask(String task) throws TaskListEmptyException, TaskNotFoundException {
    if (tasks.isEmpty()) {
      throw new TaskListEmptyException("The tasks list is empty");
    }
    if (!tasks.contains(task)) {
      throw new TaskNotFoundException("The task you provide does not exist");
    }
    tasks.remove(task);
    LOGGER.info("Task removed successfully");
  }
}