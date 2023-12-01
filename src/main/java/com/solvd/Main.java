package com.solvd;

import com.solvd.classes.*;
import com.solvd.enums.*;
import com.solvd.exceptions.*;
import com.solvd.custom.CustomLinkedList;
import com.solvd.interfaces.functional.TestifyFunction;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    Court court1 = new Court("New York County Supreme Court", "60 Centre St, New York, NY 10007, United States", CourtType.FAMILY_LAW);
    Judge judge1 = new Judge("Alice Jones", 6, "JN-9285", LegalSpecialization.FAMILY_LAW);
    // Adding the court to the judge to evaluate legal cases
    try {
      judge1.setCourt(court1);
    } catch (InvalidSpecializationException e) {
      LOGGER.error(e.getMessage());
    }

    LegalCase legalCase = new LegalCase("CN-1829", "Divorce with Lana", CaseType.FAMILY);
    // Adding a document, witness and lawyer to the case. Adding the case to the law firm cases
    try {
      LegalDocument document1 = new LegalDocument(DocumentType.DIVORCE, new Date(), DocumentStatus.DRAFT);
      // Changing the document status to approved to add to the case
      document1.changeDocumentStatus(DocumentStatus.APPROVED, status -> {
        LOGGER.info("Document change their status to " + status.getDESCRIPTION());
        document1.setDocumentStatus(status);
      });
      legalCase.addDocument(document1);
      Witness witness1 = new Witness("Henry Aguirre", "+5493413927478");
      legalCase.addWitness(witness1);
      lawyer1.createCase(legalCase);
    } catch (InvalidSpecializationException | LegalCaseExistException | LegalDocumentExistException | LegalCaseStatusException |
             InvalidLegalDocumentException | WitnessExistException | LawyerExistException | LegalDocumentStatusException e) {
      LOGGER.error(e.getMessage());
    }

    // Judge evaluating a OPEN case
    try {
      judge1.evaluateCase(legalCase);
    } catch (LegalCaseStatusException | InvalidSpecializationException | LegalDocumentListEmptyException | LegalDocumentStatusException e) {
      LOGGER.error(e.getMessage());
    }

    // Witnesses providing testimony information to the specified case
    TestifyFunction<Witness, LegalCase> testifyFunction = (witness, c) -> {
      LOGGER.info(witness.getName() + " providing a testimony in the case " + c.getCaseNumber());
    };
    legalCase.getWitnesses().forEach(witness -> {
      try {
        witness.provideTestimony(legalCase, testifyFunction);
      } catch (WitnessTestimonyException | LegalCaseStatusException e) {
        LOGGER.error(e.getMessage());
      }
    });

    // Judge closing an IN PROGRESS case
    try {
      judge1.closeCase(legalCase);
    } catch (LegalCaseStatusException | InvalidSpecializationException | LegalDocumentListEmptyException | LegalDocumentStatusException e) {
      LOGGER.error(e.getMessage());
    }

    // Lawyer archiving a CLOSED case
    try {
      lawyer1.archiveCase(legalCase);
    } catch (LegalCaseStatusException | InvalidSpecializationException | LegalDocumentListEmptyException | LegalDocumentStatusException e) {
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
    LOGGER.info("The number 5 was removed from the list!");
    numbers.display();
    numbers.sort(Comparator.naturalOrder());
    LOGGER.info("The list was sorted by natural order!");
    numbers.display();

    // Read text from the file and calculate the numbers of the unique words. Write the result to the file
    try {
      File file = new File(Objects.requireNonNull(Main.class.getClassLoader().getResource("file.txt")).getFile());
      List<String> lines = FileUtils.readLines(file, "UTF-8");
      String[] allWords = StringUtils.split(lines.toString(), " ");
      Set<String> uniqueWords = new HashSet<>();
      Arrays.stream(allWords).forEach(word -> {
        word = StringUtils.strip(word, ".,");
        uniqueWords.add(word);
      });
//      FileUtils.writeStringToFile(file, "Amount of unique words in the file: " + uniqueWords.size(), "UTF-8", false);
      LOGGER.info("Amount of unique words in the file: " + uniqueWords.size());
    } catch (IOException e) {
      LOGGER.error(e.getMessage());
    }

    // Lambda functions
    // Predicate - Lambda function to check if a lawyer specialization is Family Law (lawyer input, boolean output)
    Predicate<Lawyer> lawyerSpecializationPredicate = lawyer -> lawyer.getSpecialization().equals(LegalSpecialization.FAMILY_LAW);
    LOGGER.info("Is Liam Anderson specialized at Family Law? " + lawyerSpecializationPredicate.test(lawyer2));

    // Function - Lambda function to concatenate the lawyers name and years of experience (lawyer input, string output)
    Function<Lawyer, String> lawyerConcatenateFunction = lawyer -> lawyer.getName() + " - Years of experience: " + lawyer.getExperienceYears();
    LOGGER.info(lawyerConcatenateFunction.apply(lawyer1));

    // Consumer - Lambda function to print the displayPersonInfo() of an a lawyer (lawyer input, no output)
    Consumer<Lawyer> lawyerInfoConsumer = lawyer -> lawyer.displayPersonInfo();
    lawyerInfoConsumer.accept(lawyer3);

    // Supplier - Lambda function to get a the law firm name (no input, double output)
    Supplier<String> lawFirmNameSupplier = () -> LawFirm.getInstance().getName();
    LOGGER.info(lawFirmNameSupplier.get());

    // BiPredicate - Lambda function to compare 2 lawyers specialization (2 lawyers input, boolean output)
    BiPredicate<Lawyer, Lawyer> lawyerSpecializationBiPredicate =
            (l1, l2) -> l1.getSpecialization().equals(l2.getSpecialization());
    LOGGER.info(lawyer4.getName() + " and " + lawyer2.getName() + " has the same specialization? " + lawyerSpecializationBiPredicate.test(lawyer4,
            lawyer2));

    //Collections streaming
    try {
      Set<String> lawyers5YearExperience = lawFirm.getLawyers().stream()
              .filter(lawyer -> lawyer.getExperienceYears() > 5)
              .map(lawyer -> lawyer.getName())
              .collect(Collectors.toSet());
      lawyers5YearExperience.forEach(lawyer -> {
        LOGGER.info(lawyer + " is a lawyer with more than 5 years of experience");
      });
    } catch (LawyerListEmptyException e) {
       LOGGER.error(e.getMessage());
    }

    try {
      Set<LegalCase> openCases = lawFirm.getCases().stream()
              .filter(c -> c.getStatus().equals(CaseStatus.OPEN))
              .collect(Collectors.toSet());
      openCases.forEach(c -> {
        LOGGER.info(c.getCaseNumber() + " case is opened");
      });
    } catch (LegalCaseListEmptyException e) {
       LOGGER.error(e.getMessage());
    }

    try {
      Set<String> laborLawAssistants = lawFirm.getAssistants().stream()
              .filter(assistant -> assistant.getSpecialization().equals(LegalSpecialization.LABOR_LAW))
              .map(assistant -> assistant.getName())
              .collect(Collectors.toSet());
    } catch (LegalAssistantListEmptyException e) {
       LOGGER.error(e.getMessage());
    }

    try {
      Set<String> clientsFromNY = lawFirm.getClients().stream()
              .filter(client -> client.getContactInfo().contains("NY"))
              .map(client -> client.getName())
              .collect(Collectors.toSet());
    } catch (ClientListEmptyException e) {
       LOGGER.error(e.getMessage());
    }

    try {
      Set<LegalDocument> draftDocumentsCase1 = legalCase.getDocuments().stream()
              .filter(document -> document.getDocumentStatus().equals(DocumentStatus.DRAFT))
              .collect(Collectors.toSet());
    } catch (LegalDocumentListEmptyException e) {
       LOGGER.error(e.getMessage());
    }

    try {
      Set<LegalDocument> allApprovedDocuments = lawFirm.getCases().stream()
              .flatMap(c -> {
                        try {
                          return c.getDocuments().stream()
                                  .filter(document -> document.getDocumentStatus().equals(DocumentStatus.APPROVED));
                        } catch (LegalDocumentListEmptyException e) {
                           LOGGER.error(e.getMessage());
                           return Stream.empty();
                        }
                      }
              ).collect(Collectors.toSet());
    } catch (LegalCaseListEmptyException e) {
      LOGGER.error(e.getMessage());
    }
  }
}