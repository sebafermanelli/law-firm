package solvd.classes;

import solvd.enums.LegalSpecialization;
import solvd.exceptions.CourtDutiesException;
import solvd.interfaces.CourtOfficial;

import java.util.Arrays;
import java.util.Objects;

public class Judge extends Lawyer implements CourtOfficial {
  private Court court;

  public Judge(String name, int experienceYears, LegalSpecialization specialization, String license, Court court) {
    super(name, experienceYears, specialization, license);
    this.court = court;
  }

  public Court getCourt() {
    return court;
  }

  public void setCourt(Court court) {
    this.court = court;
  }

  @Override
  public String toString() {
    return "Judge{" +
            "court=" + court +
            ", license='" + license + '\'' +
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
    Judge judge = (Judge) o;
    return Objects.equals(getCourt(), judge.getCourt());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getCourt());
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
