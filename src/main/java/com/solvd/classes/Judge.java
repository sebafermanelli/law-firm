package com.solvd.classes;

import com.solvd.enums.CaseStatus;
import com.solvd.enums.DocumentStatus;
import com.solvd.enums.LegalSpecialization;
import com.solvd.exceptions.*;
import com.solvd.interfaces.CourtOfficial;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Judge extends LegalPerson implements CourtOfficial {
  private static final Logger LOGGER = LogManager.getLogger(Judge.class);
  private String license;
  private LegalSpecialization specialization;
  private Court court;

  public Judge(String name, int experienceYears, String license, LegalSpecialization specialization) {
    super(name, experienceYears);
    this.license = license;
    this.specialization = specialization;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public LegalSpecialization getSpecialization() {
    return specialization;
  }

  public void setSpecialization(LegalSpecialization specialization) {
    this.specialization = specialization;
  }

  public Court getCourt() {
    return court;
  }

  public void setCourt(Court court) throws InvalidSpecializationException {
    if (!specialization.equals(court.getCourtType().getJUDGE_SPECIALIZATION())) {
      throw new InvalidSpecializationException("The specialization does not apply for this court");
    }
    this.court = court;
  }

  @Override
  public String toString() {
    return "Judge{" +
            "license='" + license + '\'' +
            ", specialization=" + specialization +
            ", court=" + court +
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
    return Objects.equals(getLicense(), judge.getLicense()) && getSpecialization() == judge.getSpecialization() && Objects.equals(getCourt(), judge.getCourt());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getLicense(), getSpecialization(), getCourt());
  }

  @Override
  public void displayPersonInfo() {
    LOGGER.info("Judge Information: " + this);
  }

  @Override
  public void evaluateCase(LegalCase legalCase) throws LegalCaseStatusException, InvalidSpecializationException, LegalDocumentStatusException, LegalDocumentListEmptyException {
    if (!legalCase.getStatus().equals(CaseStatus.OPEN)) {
      throw new LegalCaseStatusException("The status of the case is not open");
    }
    // Check if any document of the case were not approved
    List<DocumentStatus> documentsNotApprovedList = legalCase.getDocuments().stream()
            .map(LegalDocument::getDocumentStatus)
            .filter(status -> !status.equals(DocumentStatus.APPROVED))
            .collect(Collectors.toList());
    if (!documentsNotApprovedList.isEmpty()) {
      throw new LegalDocumentStatusException("Any document status of the case were not approved");
    }
    if (!specialization.equals(legalCase.getCaseType().getCOURT_TYPE().getJUDGE_SPECIALIZATION())) {
      throw new InvalidSpecializationException("The specialization does not apply for this case");
    }
    legalCase.changeCaseStatus(CaseStatus.IN_PROGRESS, status -> legalCase.setStatus(status));
    LOGGER.info("Judge evaluating the case, changing to in progress status...");
  }

  @Override
  public void closeCase(LegalCase legalCase) throws LegalCaseStatusException, InvalidSpecializationException, LegalDocumentListEmptyException, LegalDocumentStatusException {
    if (!legalCase.getStatus().equals(CaseStatus.IN_PROGRESS)) {
      throw new LegalCaseStatusException("The status of the case is not in progress");
    }
    // Check if any document of the case were not approved
    List<DocumentStatus> documentsNotApprovedList = legalCase.getDocuments().stream()
            .map(LegalDocument::getDocumentStatus)
            .filter(status -> !status.equals(DocumentStatus.APPROVED))
            .collect(Collectors.toList());
    if (!documentsNotApprovedList.isEmpty()) {
      throw new LegalDocumentStatusException("Any document status of the case were not approved");
    }
    if (!specialization.equals(legalCase.getCaseType().getCOURT_TYPE().getJUDGE_SPECIALIZATION())) {
      throw new InvalidSpecializationException("The specialization does not apply for this case");
    }
    legalCase.changeCaseStatus(CaseStatus.CLOSED, status -> legalCase.setStatus(status));
    LOGGER.info("Judge closing the case, changing to closed status...");
  }
}
