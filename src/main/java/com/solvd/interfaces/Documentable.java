package com.solvd.interfaces;

import com.solvd.exceptions.*;
import com.solvd.classes.LegalCase;
import com.solvd.classes.LegalDocument;
import org.solvd.exceptions.*;

public interface Documentable {
  void addDocument(LegalCase legalCase, LegalDocument document) throws InvalidLegalDocumentException,
          LegalDocumentExistException, LegalCaseStatusException, InvalidSpecializationException;

  void deleteDocument(LegalCase legalCase, LegalDocument document) throws InvalidLegalDocumentException,
          LegalDocumentNotFoundException, LegalCaseStatusException, InvalidSpecializationException;
}
