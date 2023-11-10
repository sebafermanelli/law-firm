package solvd.interfaces;

import solvd.classes.LegalCase;
import solvd.classes.LegalDocument;
import solvd.exceptions.InvalidLegalDocumentException;

public interface Documentable {
  void createDocument(LegalDocument legalDocument, LegalCase legalCase) throws InvalidLegalDocumentException;
}
