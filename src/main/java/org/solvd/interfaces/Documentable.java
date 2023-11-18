package org.solvd.interfaces;

import org.solvd.classes.LegalCase;
import org.solvd.classes.LegalDocument;
import org.solvd.exceptions.*;

public interface Documentable {
  void addDocument(LegalCase legalCase, LegalDocument document) throws InvalidLegalDocumentException,
          LegalDocumentExistException, LegalCaseStatusException, InvalidSpecializationException;

  void deleteDocument(LegalCase legalCase, LegalDocument document) throws InvalidLegalDocumentException,
          LegalDocumentNotFoundException, LegalCaseStatusException, InvalidSpecializationException;
}
