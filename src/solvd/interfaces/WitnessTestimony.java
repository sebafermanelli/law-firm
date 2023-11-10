package solvd.interfaces;

import solvd.classes.LegalCase;
import solvd.exceptions.WitnessTestimonyException;

public interface WitnessTestimony {
  void provideTestimony(LegalCase legalCase) throws WitnessTestimonyException;
}
