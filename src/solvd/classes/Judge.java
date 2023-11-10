package solvd.classes;

import solvd.enums.LegalSpecialization;
import solvd.exceptions.CourtDutiesException;
import solvd.interfaces.CourtOfficial;

import java.util.Arrays;
import java.util.Objects;

public class Judge extends Lawyer implements CourtOfficial {
  private String courtRoomNumber;

  public Judge(String name, int experienceYears, String[] tasks, LegalSpecialization specialization, String license, String courtRoomNumber) {
    super(name, experienceYears, tasks, specialization, license);
    this.courtRoomNumber = courtRoomNumber;
  }

  public String getCourtRoomNumber() {
    return courtRoomNumber;
  }

  public void setCourtRoomNumber(String courtRoomNumber) {
    this.courtRoomNumber = courtRoomNumber;
  }

  @Override
  public String toString() {
    return "Judge{" +
            "courtRoomNumber='" + courtRoomNumber + '\'' +
            ", license=" + license +
            ", specialization=" + specialization +
            ", tasks='" + Arrays.toString(tasks) + '\'' +
            ", experienceYears=" + experienceYears +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Judge judge = (Judge) o;
    return Objects.equals(getCourtRoomNumber(), judge.getCourtRoomNumber());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCourtRoomNumber());
  }

  @Override
  public void displayPersonInfo() {
    System.out.println("Judge Information: " + toString());
  }

  @Override
  public void evaluate(LegalCase legalCase) throws CourtDutiesException {
    if(legalCase.getCaseType().equals(this.getSpecialization())) {
      System.out.println("Judge is evaluating the case number: " + legalCase.getCaseNumber());
    } else {
      throw new CourtDutiesException("Error in evaluate process, the case would be evaluated in the " + legalCase.getCaseType() + " court");
    }
  }
}
