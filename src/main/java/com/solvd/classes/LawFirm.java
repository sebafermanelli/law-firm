package com.solvd.classes;

import com.solvd.exceptions.*;
import com.solvd.interfaces.LawFirmManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

public final class LawFirm implements LawFirmManager {
  private static final LawFirm instance = new LawFirm("Nacmias Law Firm PLLC", "592 Pacific St, Brooklyn, NY 11217, United States");
  private static final Logger LOGGER = LogManager.getLogger(LawFirm.class);
  private final String name;
  private final String location;
  private HashSet<LegalSecretary> secretaries;
  private HashSet<LegalAssistant> assistants;
  private HashSet<Lawyer> lawyers;
  private HashSet<Client> clients;
  private HashSet<LegalCase> cases;

  private LawFirm(String name, String location) {
    this.name = name;
    this.location = location;
    this.secretaries = new HashSet<>();
    this.assistants = new HashSet<>();
    this.lawyers = new HashSet<>();
    this.clients = new HashSet<>();
    this.cases = new HashSet<>();
  }

  public static LawFirm getInstance() {
    return instance;
  }

  public String getName() {
    return name;
  }

  public String getLocation() {
    return location;
  }

  public HashSet<LegalSecretary> getSecretaries() throws LegalSecretaryListEmptyException {
    if (secretaries.isEmpty()) {
      throw new LegalSecretaryListEmptyException("The secretary list is empty");
    }
    return secretaries;
  }

  public void setSecretaries(HashSet<LegalSecretary> secretaries) {
    this.secretaries = secretaries;
  }

  public HashSet<LegalAssistant> getAssistants() throws LegalAssistantListEmptyException {
    if (assistants.isEmpty()) {
      throw new LegalAssistantListEmptyException("The assistant list is empty");
    }
    return assistants;
  }

  public void setAssistants(HashSet<LegalAssistant> assistants) {
    this.assistants = assistants;
  }

  public HashSet<Lawyer> getLawyers() throws LawyerListEmptyException {
    if (lawyers.isEmpty()) {
      throw new LawyerListEmptyException("The lawyer list is empty");
    }
    return lawyers;
  }

  public void setLawyers(HashSet<Lawyer> lawyers) {
    this.lawyers = lawyers;
  }

  public HashSet<Client> getClients() throws ClientListEmptyException {
    if (clients.isEmpty()) {
      throw new ClientListEmptyException("The client list is empty");
    }
    return clients;
  }

  public void setClients(HashSet<Client> clients) {
    this.clients = clients;
  }

  public HashSet<LegalCase> getCases() throws LegalCaseListEmptyException {
    if (cases.isEmpty()) {
      throw new LegalCaseListEmptyException("The case list is empty");
    }
    return cases;
  }

  public void setCases(HashSet<LegalCase> cases) {
    this.cases = cases;
  }

  @Override
  public String toString() {
    return "LawFirm{" +
            "name='" + name + '\'' +
            ", location='" + location + '\'' +
            ", secretaries=" + secretaries +
            ", assistants=" + assistants +
            ", lawyers=" + lawyers +
            ", clients=" + clients +
            ", cases=" + cases +
            '}';
  }

  @Override
  public void addSecretary(LegalSecretary secretary) throws LegalSecretaryExistException {
    if (secretaries.contains(secretary)) {
      throw new LegalSecretaryExistException("The secretary already registered in the law firm");
    }
    secretaries.add(secretary);
    LOGGER.info("Secretary added successfully");
  }

  @Override
  public void addAssistant(LegalAssistant assistant) throws LegalAssistantExistException {
    if (assistants.contains(assistant)) {
      throw new LegalAssistantExistException("The assistant already registered in the law firm");
    }
    assistants.add(assistant);
    LOGGER.info("Assistant added successfully");
  }

  @Override
  public void addLawyer(Lawyer lawyer) throws LawyerExistException {
    if (lawyers.contains(lawyer)) {
      throw new LawyerExistException("The lawyer already registered in the law firm");
    }
    lawyers.add(lawyer);
    LOGGER.info("Lawyer added successfully");
  }

  @Override
  public void addClient(Client client) throws ClientExistException {
    if (clients.contains(client)) {
      throw new ClientExistException("The client already registered in the law firm");
    }
    clients.add(client);
    LOGGER.info("Client added successfully");
  }

  @Override
  public void addCase(LegalCase legalCase) throws LegalCaseExistException {
    if (cases.contains(legalCase)) {
      throw new LegalCaseExistException("The case already registered in the law firm");
    }
    cases.add(legalCase);
    LOGGER.info("Case added successfully");
  }

  @Override
  public void deleteSecretary(LegalSecretary secretary) throws LegalSecretaryNotFoundException {
    if (!secretaries.contains(secretary)) {
      throw new LegalSecretaryNotFoundException("The secretary does not exist in the law firm");
    }
    secretaries.remove(secretary);
    LOGGER.info("Secretary removed successfully");
  }

  @Override
  public void deleteAssistant(LegalAssistant assistant) throws LegalAssistantNotFoundException {
    if (!assistants.contains(assistant)) {
      throw new LegalAssistantNotFoundException("The assistant does not exist in the law firm");
    }
    assistants.remove(assistant);
    LOGGER.info("Assistant removed successfully");
  }

  @Override
  public void deleteLawyer(Lawyer lawyer) throws LawyerNotFoundException {
    if (!lawyers.contains(lawyer)) {
      throw new LawyerNotFoundException("The lawyer does not exist in the law firm");
    }
    lawyers.remove(lawyer);
    LOGGER.info("Lawyer removed successfully");
  }

  @Override
  public void deleteClient(Client client) throws ClientNotFoundException {
    if (!clients.contains(client)) {
      throw new ClientNotFoundException("The client does not exist in the law firm");
    }
    clients.remove(client);
    LOGGER.info("Client removed successfully");
  }

  @Override
  public void deleteCase(LegalCase legalCase) throws LegalCaseNotFoundException {
    if (!cases.contains(legalCase)) {
      throw new LegalCaseNotFoundException("The case does not exist in the law firm");
    }
    cases.remove(legalCase);
    LOGGER.info("Case removed successfully");
  }
}
