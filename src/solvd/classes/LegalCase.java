package solvd.classes;

import solvd.enums.LegalSpecialization;

import java.util.HashSet;
import java.util.Objects;

public class LegalCase {
  private String caseNumber;
  private String description;
  private LegalSpecialization caseType;
  private Court court;
  private HashSet<LegalDocument> documents;
  private HashSet<Lawyer> lawyers;
  private HashSet<Client> clients;
  private HashSet<Witness> witnesses;

  public LegalCase(String caseNumber, String description, LegalSpecialization caseType) {
    this.caseNumber = caseNumber;
    this.description = description;
    this.caseType = caseType;
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

  public HashSet<LegalDocument> getDocuments() {
    return documents;
  }

  public void setDocuments(HashSet<LegalDocument> documents) {
    this.documents = documents;
  }

  public HashSet<Lawyer> getLawyers() {
    return lawyers;
  }

  public void setLawyers(HashSet<Lawyer> lawyers) {
    this.lawyers = lawyers;
  }

  public HashSet<Client> getClients() {
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
    return Objects.equals(getCaseNumber(), legalCase.getCaseNumber()) && Objects.equals(getDescription(), legalCase.getDescription()) && getCaseType() == legalCase.getCaseType() && Objects.equals(getCourt(), legalCase.getCourt()) && Objects.equals(getDocuments(), legalCase.getDocuments()) && Objects.equals(getLawyers(), legalCase.getLawyers()) && Objects.equals(getClients(), legalCase.getClients()) && Objects.equals(getWitnesses(), legalCase.getWitnesses());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCaseNumber(), getDescription(), getCaseType(), getCourt(), getDocuments(), getLawyers(), getClients(), getWitnesses());
  }
}
