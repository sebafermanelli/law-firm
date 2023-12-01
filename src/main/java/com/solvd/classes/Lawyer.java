package com.solvd.classes;

import com.solvd.enums.CaseStatus;
import com.solvd.enums.DocumentStatus;
import com.solvd.enums.LegalSpecialization;
import com.solvd.exceptions.*;
import com.solvd.interfaces.LegalPractitioner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    LOGGER.info("Lawyer Information: " + this);
  }

  @Override
  public void createCase(LegalCase legalCase) throws InvalidSpecializationException,
          LegalCaseExistException, LegalCaseStatusException, LawyerExistException {
    if (!specialization.equals(legalCase.getCaseType().getLEGAL_SPECIALIZATION())) {
      throw new InvalidSpecializationException("The specialization does not apply for this case");
    }
    legalCase.addLawyer(this);
    LawFirm.getInstance().addCase(legalCase);
  }

  @Override
  public void archiveCase(LegalCase legalCase) throws InvalidSpecializationException, LegalCaseStatusException, LegalDocumentListEmptyException, LegalDocumentStatusException {
    if (!specialization.equals(legalCase.getCaseType().getLEGAL_SPECIALIZATION())) {
      throw new InvalidSpecializationException("The specialization does not apply for this case");
    }
    // Check if any document of the case were not approved
    List<DocumentStatus> documentsNotApprovedList = legalCase.getDocuments().stream()
            .map(LegalDocument::getDocumentStatus)
            .filter(status -> !status.equals(DocumentStatus.APPROVED))
            .collect(Collectors.toList());
    if (!documentsNotApprovedList.isEmpty()) {
      throw new LegalDocumentStatusException("Any document status of the case were not approved");
    }
    if (!legalCase.getStatus().equals(CaseStatus.CLOSED)) {
      throw new LegalCaseStatusException("The status of the case is not closed");
    }
    legalCase.changeCaseStatus(CaseStatus.ARCHIVED, status -> legalCase.setStatus(status));
    LOGGER.info("The case was archived...");
  }
}