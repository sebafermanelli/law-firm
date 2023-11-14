package solvd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.classes.*;
import solvd.enums.DocumentType;
import solvd.enums.LegalSpecialization;

import java.util.Date;
import java.util.HashSet;

public class Main {
  static {
    System.setProperty("log4j.configurationFile", "log4j2.xml");
  }

  private static final Logger LOGGER = LogManager.getLogger(Main.class);

  public static void main(String[] args) {
    LOGGER.info("Hello World");

    LawFirm lawFirm = new LawFirm("Nacmias Law Firm PLLC", "592 Pacific St, Brooklyn, NY 11217, United States");
    LegalSecretary legalSecretary1 = new LegalSecretary("Caroline Smith", 2);
    LegalAssistant legalAssistant1 = new LegalAssistant("Jackson Villa", 3, LegalSpecialization.FAMILY_LAW);
    Lawyer lawyer1 = new Lawyer("Anna Scott", 3, LegalSpecialization.FAMILY_LAW, "LN-18239");

    Court court1 = new Court("New York County Supreme Court", "60 Centre St, New York, NY 10007, United States", LegalSpecialization.FAMILY_LAW);
    Judge judge1 = new Judge("Alice Jones", 6, LegalSpecialization.FAMILY_LAW, "LN-82374", court1);

    Client client1 = new Client("Paul Doe", "+5492476829457");
    LegalCase legalCase1 = new LegalCase("CN-1829", "Divorce with Lana", LegalSpecialization.FAMILY_LAW);
    LegalDocument legalDocument1 = new LegalDocument(DocumentType.DIVORCE, new Date());
    Witness witness1 = new Witness("Henry Aguirre", "+5493413927478");

    HashSet<LegalDocument> legalDocuments = new HashSet<>();
    legalDocuments.add(legalDocument1);
    legalCase1.setDocuments(legalDocuments);
    System.out.println(legalCase1.getDocuments());

    System.out.println(legalCase1.toString());
  }
}