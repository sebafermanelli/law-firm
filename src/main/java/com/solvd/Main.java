package com.solvd;

import com.solvd.classes.*;
import com.solvd.enums.DocumentType;
import com.solvd.enums.LegalSpecialization;
import com.solvd.exceptions.*;
import com.solvd.lists.CustomLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.Date;

public class Main {
  private static final Logger LOGGER = LogManager.getLogger(Main.class);

  static {
    System.setProperty("log4j.configurationFile", "log4j2.xml");
  }

  public static void main(String[] args) {
    LegalConstants.displayLegalSystemInfo();
    LawFirm lawFirm = LawFirm.getInstance();

    LegalSecretary secretary = new LegalSecretary("Caroline Smith", 2);

    LegalAssistant assistant1 = new LegalAssistant("Jackson Villa", 3,
            LegalSpecialization.FAMILY_LAW);
    LegalAssistant assistant2 = new LegalAssistant("Ethan Walker", 6,
            LegalSpecialization.CIVIL_COMMERCIAL_LAW);
    LegalAssistant assistant3 = new LegalAssistant("Emma Wallace", 8,
            LegalSpecialization.LABOR_LAW);
    Lawyer lawyer1 = new Lawyer("Anna Scott", 3, LegalSpecialization.FAMILY_LAW, "LN-29184");
    Lawyer lawyer2 = new Lawyer("Liam Anderson", 7, LegalSpecialization.CIVIL_COMMERCIAL_LAW, "LN" +
            "-92834");
    Lawyer lawyer3 = new Lawyer("Noah Palmer", 1, LegalSpecialization.LABOR_LAW, "LN-29488");
    Lawyer lawyer4 = new Lawyer("Isabella Jenkins", 9, LegalSpecialization.PENAL_LAW, "LN-11293");

    Client client1 = new Client("Alice Johnson", "+551234567890");
    Client client2 = new Client("Michael Smith", "+554321098765");
    Client client3 = new Client("Emily Brown", "+556789012345");
    Client client4 = new Client("David Taylor", "+559876543210");
    Client client5 = new Client("Sophia Miller", "+558765432109");
    // Adding secretaries, assistants, lawyers and clients to the law firm
    try {
      lawFirm.addSecretary(secretary);

      lawFirm.addAssistant(assistant1);
      lawFirm.addAssistant(assistant2);
      lawFirm.addAssistant(assistant3);

      lawFirm.addLawyer(lawyer1);
      lawFirm.addLawyer(lawyer2);
      lawFirm.addLawyer(lawyer3);
      lawFirm.addLawyer(lawyer4);

      lawFirm.addClient(client1);
      lawFirm.addClient(client2);
      lawFirm.addClient(client3);
      lawFirm.addClient(client4);
      lawFirm.addClient(client5);
    } catch (LegalSecretaryExistException | LegalAssistantExistException | LawyerExistException |
             ClientExistException e) {
      LOGGER.error(e.getMessage());
    }

    Court court1 = new Court("New York County Supreme Court", "60 Centre St, New York, NY 10007, United States", LegalSpecialization.FAMILY_LAW);
    Judge judge1 = new Judge("Alice Jones", 6, "JN-9285", LegalSpecialization.FAMILY_LAW);
    // Adding the court to the judge to evaluate legal cases
    try {
      judge1.setCourt(court1);
    } catch (InvalidSpecializationException e) {
      LOGGER.error(e.getMessage());
    }

    LegalCase legalCase = new LegalCase("CN-1829", "Divorce with Lana", LegalSpecialization.FAMILY_LAW);
    // Addming a document, witness and lawyer to the case. Adding the case to the law firm cases
    try {
      LegalDocument document1 = new LegalDocument(DocumentType.FAMILY_LAW_DIVORCE, new Date());
      legalCase.addDocument(document1);

      Witness witness1 = new Witness("Henry Aguirre", "+5493413927478");
      legalCase.addWitness(witness1);

      lawyer1.createCase(legalCase);
    } catch (InvalidSpecializationException | LegalCaseExistException |
             LegalDocumentExistException | LegalCaseStatusException |
             InvalidLegalDocumentException | WitnessExistException | LawyerExistException e) {
      LOGGER.error(e.getMessage());
    }

    // Judge evaluating a OPEN case
    try {
      judge1.evaluateCase(legalCase);
    } catch (LegalCaseStatusException | InvalidSpecializationException e) {
      LOGGER.error(e.getMessage());
    }

    // Judge closing a IN PROCESS case
    try {
      judge1.closeCase(legalCase);
    } catch (LegalCaseStatusException | InvalidSpecializationException e) {
      LOGGER.error(e.getMessage());
    }

    // Lawyer archiving a CLOSED case
    try {
      lawyer1.archiveCase(legalCase);
    } catch (LegalCaseStatusException | InvalidSpecializationException e) {
      LOGGER.error(e.getMessage());
    }

    // CustomLinkedList test
    CustomLinkedList<Integer> numbers = new CustomLinkedList<>();
    numbers.add(4);
    numbers.add(3);
    numbers.add(5);
    numbers.add(1);
    numbers.add(2);

    numbers.display();

    numbers.remove(5);
    LOGGER.warn("The number 5 was removed from the list!");
    numbers.display();

    numbers.sort(Comparator.naturalOrder());
    LOGGER.warn("The list was sorted by natural order!");
    numbers.display();
  }
}