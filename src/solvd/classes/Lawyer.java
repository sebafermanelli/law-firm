package solvd.classes;

import solvd.enums.LegalSpecialization;
import solvd.exceptions.CourtDutiesException;
import solvd.interfaces.LegalPractitioner;

import java.util.Arrays;
import java.util.Objects;

public class Lawyer extends LegalAssistant implements LegalPractitioner {
  protected String license;

  public Lawyer(String name, int experienceYears, LegalSpecialization specialization, String license) {
    super(name, experienceYears, specialization);
    this.license = license;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  @Override
  public String toString() {
    return "Lawyer{" +
            "license='" + license + '\'' +
            ", specialization=" + specialization +
            ", tasks=" + tasks +
            ", experienceYears=" + experienceYears +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Lawyer lawyer = (Lawyer) o;
    return Objects.equals(getLicense(), lawyer.getLicense());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getLicense());
  }

  @Override
  public void displayPersonInfo() {
    System.out.println("Lawyer Information: " + toString());
  }

  @Override
  public void performCourtDuties() throws CourtDutiesException {
    System.out.println("Lawyer is performing court duties.");
    throw new CourtDutiesException("Error in performing court duties process");
  }
}