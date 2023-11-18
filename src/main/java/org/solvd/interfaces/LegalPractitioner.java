package org.solvd.interfaces;

import org.solvd.classes.LegalCase;
import org.solvd.exceptions.InvalidSpecializationException;
import org.solvd.exceptions.LawyerExistException;
import org.solvd.exceptions.LegalCaseExistException;
import org.solvd.exceptions.LegalCaseStatusException;

public interface LegalPractitioner {
  // Method to create a new case to clients with witnesses and documents
  void createCase(LegalCase legalCase) throws InvalidSpecializationException, LegalCaseExistException, LegalCaseStatusException, LawyerExistException;

  // Method to archive a CLOSED case in the law firm
  void archiveCase(LegalCase legalCase) throws InvalidSpecializationException, LegalCaseStatusException;
}
