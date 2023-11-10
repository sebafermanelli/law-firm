package solvd.classes;

import solvd.exceptions.LegalEntityNotFoundException;
import solvd.interfaces.LegalEntity;

import java.util.Objects;

public class LawFirm implements LegalEntity {
  private String name;
  private String location;

  public LawFirm(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return "LawFirm{" +
            "name='" + name + '\'' +
            ", location='" + location + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LawFirm lawFirm = (LawFirm) o;
    return Objects.equals(getName(), lawFirm.getName()) && Objects.equals(getLocation(), lawFirm.getLocation());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getLocation());
  }

  @Override
  public void findLegalEntity() throws LegalEntityNotFoundException {
    System.out.println("Law firm '" + name + "' is registered as a legal entity.");
    throw new LegalEntityNotFoundException("Error in legal entity search process");
  }
}
