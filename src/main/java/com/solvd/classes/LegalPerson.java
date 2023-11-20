package com.solvd.classes;

import java.util.Objects;

public abstract class LegalPerson extends Person {
  protected int experienceYears;

  public LegalPerson(String name, int experienceYears) {
    super(name);
    this.experienceYears = experienceYears;
  }

  public int getExperienceYears() {
    return experienceYears;
  }

  public void setExperienceYears(int experienceYears) {
    this.experienceYears = experienceYears;
  }

  @Override
  public String toString() {
    return "LegalPerson{" +
            "experienceYears=" + experienceYears +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    LegalPerson that = (LegalPerson) o;
    return getExperienceYears() == that.getExperienceYears();
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getExperienceYears());
  }
}
