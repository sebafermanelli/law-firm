package org.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solvd.enums.CaseStatus;
import org.solvd.enums.LegalSpecialization;
import org.solvd.exceptions.InvalidSpecializationException;
import org.solvd.exceptions.LawyerExistException;
import org.solvd.exceptions.LegalCaseExistException;
import org.solvd.exceptions.LegalCaseStatusException;
import org.solvd.interfaces.LegalPractitioner;

import java.util.Objects;

public class Lawyer extends LegalAssistant implements LegalPractitioner {
  private static final Logger LOGGER = LogManager.getLogger(Lawyer.class);
  private String license;

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
    LOGGER.info("Lawyer Information: " + toString());
  }

  @Override
  public void createCase(LegalCase legalCase) throws InvalidSpecializationException,
          LegalCaseExistException, LegalCaseStatusException, LawyerExistException {
    if (!specialization.equals(legalCase.getCaseType())) {
      throw new InvalidSpecializationException("The specialization does not apply for this case");
    }
    legalCase.addLawyer(this);
    LawFirm.getInstance().addCase(legalCase);
  }

  @Override
  public void archiveCase(LegalCase legalCase) throws InvalidSpecializationException, LegalCaseStatusException {
    if (!specialization.equals(legalCase.getCaseType())) {
      throw new InvalidSpecializationException("The specialization does not apply for this case");
    }
    if (!legalCase.getStatus().equals(CaseStatus.CLOSED)) {
      throw new LegalCaseStatusException("The status of the case is not closed");
    }
    legalCase.setStatus(CaseStatus.ARCHIVED);
    LOGGER.info("The case was archived...");
  }
}