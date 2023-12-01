package com.solvd.interfaces;

import com.solvd.classes.LegalCase;
import com.solvd.classes.LegalDocument;
import com.solvd.exceptions.*;

public interface Documentable {
  void addDocument(LegalCase legalCase, LegalDocument document) throws InvalidLegalDocumentException,
          LegalDocumentExistException, LegalCaseStatusException, InvalidSpecializationException, LegalDocumentStatusException;

  void deleteDocument(LegalCase legalCase, LegalDocument document) throws InvalidLegalDocumentException,
          LegalDocumentNotFoundException, LegalCaseStatusException, InvalidSpecializationException;
}
