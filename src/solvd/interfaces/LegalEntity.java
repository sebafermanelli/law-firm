package solvd.interfaces;

import solvd.exceptions.LegalEntityNotFoundException;

public interface LegalEntity {
  void findLegalEntity() throws LegalEntityNotFoundException;
}
