package solvd.classes;

import solvd.enums.LegalSpecialization;

import java.util.Objects;

public class LegalCase {
  private String caseNumber;
  private String description;
  private LegalSpecialization caseType;

  public LegalCase(String caseNumber, String description, LegalSpecialization caseType) {
    this.caseNumber = caseNumber;
    this.description = description;
    this.caseType = caseType;
  }

  public String getCaseNumber() {
    return caseNumber;
  }

  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LegalSpecialization getCaseType() {
    return caseType;
  }

  public void setCaseType(LegalSpecialization caseType) {
    this.caseType = caseType;
  }

  @Override
  public String toString() {
    return "Case{" +
            "caseNumber='" + caseNumber + '\'' +
            ", description='" + description + '\'' +
            ", caseType=" + caseType +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LegalCase aCase = (LegalCase) o;
    return Objects.equals(getCaseNumber(), aCase.getCaseNumber()) && Objects.equals(getDescription(), aCase.getDescription()) && getCaseType() == aCase.getCaseType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCaseNumber(), getDescription(), getCaseType());
  }
}
