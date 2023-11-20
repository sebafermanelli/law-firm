package com.solvd.interfaces;

import com.solvd.classes.LegalCase;
import com.solvd.exceptions.InvalidSpecializationException;
import com.solvd.exceptions.LawyerExistException;
import com.solvd.exceptions.LegalCaseExistException;
import com.solvd.exceptions.LegalCaseStatusException;

public interface LegalPractitioner {
  // Method to create a new case to clients with witnesses and documents
  void createCase(LegalCase legalCase) throws InvalidSpecializationException, LegalCaseExistException, LegalCaseStatusException, LawyerExistException;

  // Method to archive a CLOSED case in the law firm
  void archiveCase(LegalCase legalCase) throws InvalidSpecializationException, LegalCaseStatusException;
}
