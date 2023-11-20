package com.solvd.classes;

import com.solvd.exceptions.*;
import com.solvd.interfaces.Documentable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.enums.LegalSpecialization;
import org.solvd.exceptions.*;

import java.util.Objects;

public class LegalAssistant extends LegalSecretary implements Documentable {
  private static final Logger LOGGER = LogManager.getLogger(LegalAssistant.class);
  protected LegalSpecialization specialization;

  public LegalAssistant(String name, int experienceYears, LegalSpecialization specialization) {
    super(name, experienceYears);
    this.specialization = specialization;
  }

  public LegalSpecialization getSpecialization() {
    return specialization;
  }

  public void setSpecialization(LegalSpecialization specialization) {
    this.specialization = specialization;
  }

  @Override
  public String toString() {
    return "LegalAssistant{" + "specialization=" + specialization + ", tasks=" + tasks + ", experienceYears=" + experienceYears + ", name='" + name + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    LegalAssistant that = (LegalAssistant) o;
    return Objects.equals(getSpecialization(), that.getSpecialization());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getSpecialization());
  }

  @Override
  public void displayPersonInfo() {
    LOGGER.info("Legal Assistant Information: " + toString());
  }

  @Override
  public void addDocument(LegalCase legalCase, LegalDocument document) throws InvalidSpecializationException, LegalDocumentExistException, LegalCaseStatusException, InvalidLegalDocumentException {
    if (!specialization.equals(legalCase.getCaseType())) {
      throw new InvalidSpecializationException("The specialization does not apply for this case");
    }
    legalCase.addDocument(document);
  }

  @Override
  public void deleteDocument(LegalCase legalCase, LegalDocument document) throws LegalDocumentNotFoundException, LegalCaseStatusException, InvalidLegalDocumentException, InvalidSpecializationException {
    if (!specialization.equals(legalCase.getCaseType())) {
      throw new InvalidSpecializationException("The specialization does not apply for this case");
    }
    legalCase.deleteDocument(document);
  }
}