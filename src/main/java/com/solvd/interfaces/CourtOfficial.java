package com.solvd.interfaces;

import com.solvd.classes.LegalCase;
import com.solvd.exceptions.InvalidSpecializationException;
import com.solvd.exceptions.LegalCaseStatusException;

public interface CourtOfficial {
  // Method to evaluate OPEN case
  void evaluateCase(LegalCase legalCase) throws LegalCaseStatusException, InvalidSpecializationException;

  // Method to close IN PROCESS case
  void closeCase(LegalCase legalCase) throws LegalCaseStatusException, InvalidSpecializationException;
}
