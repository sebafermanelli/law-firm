package org.solvd.interfaces;

import org.solvd.classes.LegalCase;
import org.solvd.exceptions.InvalidSpecializationException;
import org.solvd.exceptions.LegalCaseStatusException;

public interface CourtOfficial {
  // Method to evaluate OPEN case
  void evaluateCase(LegalCase legalCase) throws LegalCaseStatusException, InvalidSpecializationException;

  // Method to close IN PROCESS case
  void closeCase(LegalCase legalCase) throws LegalCaseStatusException, InvalidSpecializationException;
}
