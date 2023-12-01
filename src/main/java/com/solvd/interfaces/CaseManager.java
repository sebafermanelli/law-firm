package com.solvd.interfaces;

import com.solvd.classes.Client;
import com.solvd.classes.Lawyer;
import com.solvd.classes.LegalDocument;
import com.solvd.classes.Witness;
import com.solvd.exceptions.*;

public interface CaseManager {
  void addDocument(LegalDocument document) throws LegalDocumentExistException,
          InvalidLegalDocumentException, LegalCaseStatusException, LegalDocumentStatusException;

  void addLawyer(Lawyer lawyer) throws InvalidSpecializationException,
          LawyerExistException, LegalCaseStatusException;

  void addClient(Client client) throws ClientExistException, LegalCaseStatusException;

  void addWitness(Witness witness) throws WitnessExistException, LegalCaseStatusException;

  void deleteDocument(LegalDocument document) throws InvalidLegalDocumentException, LegalDocumentNotFoundException, LegalCaseStatusException;

  void deleteLawyer(Lawyer lawyer) throws InvalidSpecializationException,
          LawyerNotFoundException, LegalCaseStatusException;

  void deleteClient(Client client) throws ClientNotFoundException, LegalCaseStatusException;

  void deleteWitness(Witness witness) throws WitnessNotFoundException, LegalCaseStatusException;
}
