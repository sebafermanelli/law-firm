package solvd.classes;

import solvd.exceptions.TaskNotFoundException;
import solvd.interfaces.Tasks;

import java.util.Arrays;

public class LegalSecretary extends LegalPerson implements Tasks {
  protected String[] tasks;

  public LegalSecretary(String name, int experienceYears, String[] tasks) {
    super(name, experienceYears);
    this.tasks = tasks;
  }

  public String[] getTasks() {
    return tasks;
  }

  public void setTasks(String[] tasks) {
    this.tasks = tasks;
  }

  @Override
  public String toString() {
    return "LegalSecretary{" +
            "tasks=" + Arrays.toString(tasks) +
            ", experienceYears=" + experienceYears +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public void displayPersonInfo() {
    System.out.println("Legal Secretary Information: " + toString());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    LegalSecretary that = (LegalSecretary) o;
    return Arrays.equals(getTasks(), that.getTasks());
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(getTasks());
    return result;
  }

  @Override
  public void addTask(String task) {
//    Agregar la tarea
  }

  @Override
  public void deleteTask(int indexTask) throws TaskNotFoundException {
    if((this.getTasks().length-1) >= indexTask) {
//      Eliminar la tarea
    } else {
      throw new TaskNotFoundException("The task you provide does not exist");
    }
  }
}