package org.solvd.interfaces;

import org.solvd.exceptions.LegalCaseStatusException;
import org.solvd.exceptions.WitnessTestimonyException;
import org.solvd.classes.LegalCase;

public interface WitnessTestimony {
  // Method to provide a witness testimony in an IN PROCESS case
  void provideTestimony(LegalCase legalCase) throws LegalCaseStatusException, WitnessTestimonyException;
}
