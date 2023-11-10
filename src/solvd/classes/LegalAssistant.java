package solvd.classes;

import solvd.enums.LegalSpecialization;
import solvd.exceptions.InvalidLegalDocumentException;
import solvd.interfaces.Documentable;

import java.util.Arrays;
import java.util.Objects;

public class LegalAssistant extends LegalSecretary implements Documentable {
  protected LegalSpecialization specialization;

  public LegalAssistant(String name, int experienceYears, String[] tasks, LegalSpecialization specialization) {
    super(name, experienceYears, tasks);
    this.specialization = specialization;
  }

  public LegalSpecialization getSpecialization() {
    return specialization;
  }

  public void setSpecialization(LegalSpecialization specialization) {
    this.specialization = specialization;
  }

  @Override
  public String toString() {
    return "LegalAssistant{" +
            "specialization=" + specialization +
            ", tasks=" + Arrays.toString(tasks) +
            ", experienceYears=" + experienceYears +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    LegalAssistant that = (LegalAssistant) o;
    return Objects.equals(getSpecialization(), that.getSpecialization());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getSpecialization());
  }

  @Override
  public void displayPersonInfo() {
    System.out.println("Legal Assistant Information: " + toString());
  }

  @Override
  public void createDocument(LegalDocument legalDocument, LegalCase legalCase) throws InvalidLegalDocumentException {
//    Crear un documento valido comparando los tipos de documento y especializaciones
    if (true) {
      System.out.println("Creating a legal document.");
    } else {
      throw new InvalidLegalDocumentException("Error in document creation process");
    }
  }
}