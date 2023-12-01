package com.solvd.interfaces;

import com.solvd.classes.LegalCase;
import com.solvd.classes.Witness;
import com.solvd.exceptions.LegalCaseStatusException;
import com.solvd.exceptions.WitnessTestimonyException;
import com.solvd.interfaces.functional.TestifyFunction;

public interface WitnessTestimony {
  // Method to provide a witness testimony in an IN PROCESS case
  void provideTestimony(LegalCase legalCase, TestifyFunction<Witness, LegalCase> testifyFunction) throws WitnessTestimonyException,
          LegalCaseStatusException;
}
