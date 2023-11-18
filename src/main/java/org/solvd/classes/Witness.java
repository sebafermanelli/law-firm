package org.solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solvd.enums.CaseStatus;
import org.solvd.exceptions.LegalCaseStatusException;
import org.solvd.exceptions.WitnessTestimonyException;
import org.solvd.interfaces.WitnessTestimony;

import java.util.Objects;

public class Witness extends Person implements WitnessTestimony {
  private static final Logger LOGGER = LogManager.getLogger(Witness.class);
  private String contactInfo;

  public Witness(String name, String contactInfo) {
    super(name);
    this.contactInfo = contactInfo;
  }

  public String getContactInfo() {
    return contactInfo;
  }

  public void setContactInfo(String contactInfo) {
    this.contactInfo = contactInfo;
  }

  @Override
  public void displayPersonInfo() {
    LOGGER.info("Witness Information: " + toString());
  }

  @Override
  public String toString() {
    return "Witness{" +
            "contactInfo='" + contactInfo + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Witness witness = (Witness) o;
    return Objects.equals(getContactInfo(), witness.getContactInfo());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getContactInfo());
  }

  @Override
  public void provideTestimony(LegalCase legalCase) throws WitnessTestimonyException, LegalCaseStatusException {
    if (!legalCase.getWitnesses().contains(this)) {
      throw new WitnessTestimonyException("The witness does not belong to the case");
    }
    if (!legalCase.getStatus().equals(CaseStatus.IN_PROCESS)) {
      throw new LegalCaseStatusException("The status of the case is not in process");
    }
    LOGGER.info("Providing testimony...");
  }
}
