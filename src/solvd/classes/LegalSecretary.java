package solvd.classes;

import solvd.exceptions.TaskListEmptyException;
import solvd.exceptions.TaskNotFoundException;
import solvd.interfaces.Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class LegalSecretary extends LegalPerson implements Tasks {
  protected ArrayList<String> tasks;

  public LegalSecretary(String name, int experienceYears) {
    super(name, experienceYears);
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
    System.out.println("Legal Secretary Information: " + toString());
  }

  @Override
  public void addTask(String task) {
    this.getTasks().add(task);
  }

  @Override
  public void deleteTask(int index) throws TaskNotFoundException, TaskListEmptyException {
    if (this.getTasks().isEmpty()) {
      throw new TaskListEmptyException("The tasks list is empty");
    }
    if (this.getTasks().get(index).isEmpty()) {
      throw new TaskNotFoundException("The task you provide does not exist");
    }
    this.getTasks().remove(index);
  }
}