package com.solvd.interfaces;

import com.solvd.classes.LegalCase;
import com.solvd.exceptions.InvalidSpecializationException;
import com.solvd.exceptions.LegalCaseStatusException;
import com.solvd.exceptions.LegalDocumentListEmptyException;
import com.solvd.exceptions.LegalDocumentStatusException;

public interface CourtOfficial {
  // Method to evaluate OPEN case
  void evaluateCase(LegalCase legalCase) throws LegalCaseStatusException, InvalidSpecializationException, LegalDocumentStatusException, LegalDocumentListEmptyException;

  // Method to close IN PROCESS case
  void closeCase(LegalCase legalCase) throws LegalCaseStatusException, InvalidSpecializationException, LegalDocumentListEmptyException, LegalDocumentStatusException;
}
