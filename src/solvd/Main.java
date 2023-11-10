package solvd;

import solvd.classes.*;
import solvd.enums.DocumentType;
import solvd.enums.LegalSpecialization;
import solvd.exceptions.CourtDutiesException;
import solvd.exceptions.TaskNotFoundException;
import solvd.exceptions.WitnessTestimonyException;

import java.util.Date;

public class Main {
  public static void main(String[] args) {
    String[] tasks = new String[2];
    tasks[0] = "Tarea 1";
    tasks[1] = "Tarea 2";

    LawFirm lawFirm = new LawFirm("Nacmias Law Firm PLLC", "592 Pacific St, Brooklyn, NY 11217, United States");

    Client client1 = new Client("Paul Doe", "+5492476829457");
    client1.displayPersonInfo();

    LegalSecretary legalSecretary1 = new LegalSecretary("Caroline Smith", 2, tasks);
    try {
      legalSecretary1.deleteTask(3);
    } catch (TaskNotFoundException e) {
      System.out.println("TaskNotFoundException caught: " + e.getMessage());
    }

    LegalAssistant legalAssistant1 = new LegalAssistant("Jackson Villa", 3, tasks, LegalSpecialization.FAMILY_LAW);

    Lawyer lawyer1 = new Lawyer("Anna Scott", 3, tasks, LegalSpecialization.FAMILY_LAW, "LN-18239");

    LegalDocument legalDocument1 = new LegalDocument(DocumentType.DIVORCE, new Date());

    LegalCase legalCase1 = new LegalCase("CN-1829", "Divorce with Lana", LegalSpecialization.FAMILY_LAW);

    Judge judge1 = new Judge("Alice Jones", 6, tasks, LegalSpecialization.FAMILY_LAW, "LN-82374", "FC-3");
    try {
      judge1.evaluate(legalCase1);
    } catch (CourtDutiesException e) {
      System.out.println("CourtDutiesException caught: " + e.getMessage());
    }

    Court court1 = new Court("New York County Supreme Court", "60 Centre St, New York, NY 10007, United States", LegalSpecialization.FAMILY_LAW);

    Witness witness1 = new Witness("Henry Aguirre", "+5493413927478");
    try {
      witness1.provideTestimony(legalCase1);
    } catch (WitnessTestimonyException e) {
      System.out.println("WitnessTestimonyException caught: " + e.getMessage());
    }
  }
}