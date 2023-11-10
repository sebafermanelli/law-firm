package solvd.classes;

import java.util.Objects;

public abstract class Person {
  protected String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public abstract void displayPersonInfo();

  public void commonPersonMethod() {
    System.out.println("Hi! My name is " + name);
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(getName(), person.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
