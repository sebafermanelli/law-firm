package com.solvd.interfaces;

import com.solvd.classes.LegalCase;
import com.solvd.exceptions.LegalCaseStatusException;
import com.solvd.exceptions.WitnessTestimonyException;

public interface WitnessTestimony {
  // Method to provide a witness testimony in an IN PROCESS case
  void provideTestimony(LegalCase legalCase) throws LegalCaseStatusException, WitnessTestimonyException;
}
