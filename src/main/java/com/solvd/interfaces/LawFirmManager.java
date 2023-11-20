package com.solvd.interfaces;

import com.solvd.classes.*;
import com.solvd.exceptions.*;
import org.solvd.classes.*;
import org.solvd.exceptions.*;

public interface LawFirmManager {
  void addSecretary(LegalSecretary secretary) throws LegalSecretaryExistException;

  void addAssistant(LegalAssistant assistant) throws LegalAssistantExistException;

  void addLawyer(Lawyer lawyer) throws LawyerExistException;

  void addClient(Client client) throws ClientExistException;

  void addCase(LegalCase legalCase) throws LegalCaseExistException;

  void deleteSecretary(LegalSecretary secretary) throws LegalSecretaryNotFoundException;

  void deleteAssistant(LegalAssistant assistant) throws LegalAssistantNotFoundException;

  void deleteLawyer(Lawyer lawyer) throws LawyerNotFoundException;

  void deleteClient(Client client) throws ClientNotFoundException;

  void deleteCase(LegalCase legalCase) throws LegalCaseNotFoundException;
}
