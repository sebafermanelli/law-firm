package solvd.classes;

import solvd.enums.LegalSpecialization;

import java.util.Objects;

public class Court {
  private String name;
  private String location;
  private LegalSpecialization courtType;

  public Court(String name, String location, LegalSpecialization courtType) {
    this.name = name;
    this.location = location;
    this.courtType = courtType;
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

  public LegalSpecialization getType() {
    return courtType;
  }

  public void setType(LegalSpecialization courtType) {
    this.courtType = courtType;
  }

  @Override
  public String toString() {
    return "Court{" +
            "name='" + name + '\'' +
            ", location='" + location + '\'' +
            ", courtType='" + courtType + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Court court = (Court) o;
    return Objects.equals(getName(), court.getName()) && Objects.equals(getLocation(), court.getLocation()) && Objects.equals(courtType, court.courtType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getLocation(), courtType);
  }
}
