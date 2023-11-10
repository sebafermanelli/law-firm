package solvd.interfaces;

import solvd.classes.LegalCase;
import solvd.exceptions.CourtDutiesException;

public interface CourtOfficial {
  void evaluate(LegalCase legalCase) throws CourtDutiesException;
}
