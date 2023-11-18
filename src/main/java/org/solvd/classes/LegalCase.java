package org.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solvd.enums.CaseStatus;
import org.solvd.enums.LegalSpecialization;
import org.solvd.exceptions.*;
import org.solvd.interfaces.CaseManager;

import java.util.HashSet;
import java.util.Objects;

public class LegalCase implements CaseManager {
  private static final Logger LOGGER = LogManager.getLogger(LegalCase.class);
  private String caseNumber;
  private String description;
  private CaseStatus status;
  private LegalSpecialization caseType;
  private Court court;
  private HashSet<LegalDocument> documents;
  private HashSet<Lawyer> lawyers;
  private HashSet<Client> clients;
  private HashSet<Witness> witnesses;

  public LegalCase(String caseNumber, String description, LegalSpecialization caseType) {
    this.caseNumber = caseNumber;
    this.description = description;
    this.status = CaseStatus.OPEN;
    this.caseType = caseType;
    this.documents = new HashSet<>();
    this.lawyers = new HashSet<>();
    this.clients = new HashSet<>();
    this.witnesses = new HashSet<>();
  }

  public String getCaseNumber() {
    return caseNumber;
  }

  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CaseStatus getStatus() {
    return status;
  }

  public void setStatus(CaseStatus status) {
    this.status = status;
  }

  public LegalSpecialization getCaseType() {
    return caseType;
  }

  public void setCaseType(LegalSpecialization caseType) {
    this.caseType = caseType;
  }

  public Court getCourt() {
    return court;
  }

  public void setCourt(Court court) {
    this.court = court;
  }

  public HashSet<LegalDocument> getDocuments() throws LegalDocumentListEmptyException {
    if (documents.isEmpty()) {
      throw new LegalDocumentListEmptyException("The document list is empty");
    }
    return documents;
  }

  public void setDocuments(HashSet<LegalDocument> documents) {
    this.documents = documents;
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

  public HashSet<Witness> getWitnesses() {
    return witnesses;
  }

  public void setWitnesses(HashSet<Witness> witnesses) {
    this.witnesses = witnesses;
  }

  @Override
  public String toString() {
    return "LegalCase{" +
            "caseNumber='" + caseNumber + '\'' +
            ", description='" + description + '\'' +
            ", status=" + status +
            ", caseType=" + caseType +
            ", court=" + court +
            ", documents=" + documents +
            ", lawyers=" + lawyers +
            ", clients=" + clients +
            ", witnesses=" + witnesses +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LegalCase legalCase = (LegalCase) o;
    return Objects.equals(getCaseNumber(), legalCase.getCaseNumber()) && Objects.equals(getDescription(), legalCase.getDescription()) && getCaseType() == legalCase.getCaseType() && Objects.equals(getCourt(), legalCase.getCourt());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCaseNumber(), getDescription(), getCaseType(), getCourt());
  }

  @Override
  public void addDocument(LegalDocument document) throws LegalDocumentExistException, InvalidLegalDocumentException, LegalCaseStatusException {
    if (!status.equals(CaseStatus.OPEN)) {
      throw new LegalCaseStatusException("The status of the case is not open");
    }
    if (!document.getDocumentType().toString().contains(getCaseType().toString())) {
      throw new InvalidLegalDocumentException("The document type are not valid for this case file");
    }
    if (documents.contains(document)) {
      throw new LegalDocumentExistException("The document already exist on this case file");
    }
    documents.add(document);
    LOGGER.info("The document added to the case successfully");
  }

  @Override
  public void addLawyer(Lawyer lawyer) throws InvalidSpecializationException, LawyerExistException, LegalCaseStatusException {
    if (!status.equals(CaseStatus.OPEN)) {
      throw new LegalCaseStatusException("The status of the case is not open");
    }
    if (!lawyer.getSpecialization().equals(getCaseType())) {
      throw new InvalidSpecializationException("The lawyer specialization does not apply for this case");
    }
    if (lawyers.contains(lawyer)) {
      throw new LawyerExistException("The lawyer already exist on this case file");
    }
    lawyers.add(lawyer);
    LOGGER.info("The lawyer added to the case successfully");
  }

  @Override
  public void addClient(Client client) throws ClientExistException, LegalCaseStatusException {
    if (!status.equals(CaseStatus.OPEN)) {
      throw new LegalCaseStatusException("The status of the case is not open");
    }
    if (clients.contains(client)) {
      throw new ClientExistException("The client already exist on this case file");
    }
    clients.add(client);
    LOGGER.info("The client added to the case successfully");
  }

  @Override
  public void addWitness(Witness witness) throws WitnessExistException, LegalCaseStatusException {
    if (!status.equals(CaseStatus.OPEN)) {
      throw new LegalCaseStatusException("The status of the case is not open");
    }
    if (witnesses.contains(witness)) {
      throw new WitnessExistException("The witness already exist on this case file");
    }
    witnesses.add(witness);
    LOGGER.info("The witness added to the case successfully");
  }

  @Override
  public void deleteDocument(LegalDocument document) throws InvalidLegalDocumentException, LegalDocumentNotFoundException, LegalCaseStatusException {
    if (!status.equals(CaseStatus.OPEN)) {
      throw new LegalCaseStatusException("The status of the case is not open");
    }
    if (!document.getDocumentType().toString().contains(getCaseType().toString())) {
      throw new InvalidLegalDocumentException("The document type are not valid for this case file");
    }
    if (!documents.contains(document)) {
      throw new LegalDocumentNotFoundException("The document does not exist on this case file");
    }
    documents.remove(document);
    LOGGER.info("The document removed from the case successfully");
  }

  @Override
  public void deleteLawyer(Lawyer lawyer) throws InvalidSpecializationException, LawyerNotFoundException, LegalCaseStatusException {
    if (!status.equals(CaseStatus.OPEN)) {
      throw new LegalCaseStatusException("The status of the case is not open");
    }
    if (!lawyer.getSpecialization().equals(getCaseType())) {
      throw new InvalidSpecializationException("The lawyer specialization does not apply for this case");
    }
    if (!lawyers.contains(lawyer)) {
      throw new LawyerNotFoundException("The lawyer does not exist on this case file");
    }
    lawyers.remove(lawyer);
    LOGGER.info("The lawyer removed from the case successfully");
  }

  @Override
  public void deleteClient(Client client) throws ClientNotFoundException, LegalCaseStatusException {
    if (!status.equals(CaseStatus.OPEN)) {
      throw new LegalCaseStatusException("The status of the case is not open");
    }
    if (!clients.contains(client)) {
      throw new ClientNotFoundException("The client does not exist on this case file");
    }
    clients.remove(client);
    LOGGER.info("The client removed from the case successfully");
  }

  @Override
  public void deleteWitness(Witness witness) throws WitnessNotFoundException, LegalCaseStatusException {
    if (!status.equals(CaseStatus.OPEN)) {
      throw new LegalCaseStatusException("The status of the case is not open");
    }
    if (!witnesses.contains(witness)) {
      throw new WitnessNotFoundException("The witness does not exist on this case file");
    }
    witnesses.remove(witness);
    LOGGER.info("The witness removed from the case successfully");
  }
}
