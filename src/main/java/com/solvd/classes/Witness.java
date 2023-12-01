package com.solvd.classes;

import com.solvd.enums.CaseStatus;
import com.solvd.exceptions.LegalCaseStatusException;
import com.solvd.exceptions.WitnessTestimonyException;
import com.solvd.interfaces.WitnessTestimony;
import com.solvd.interfaces.functional.TestifyFunction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    LOGGER.info("Witness Information: " + this);
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
  public void provideTestimony(LegalCase legalCase, TestifyFunction<Witness, LegalCase> testifyFunction) throws WitnessTestimonyException,
          LegalCaseStatusException {
    if (!legalCase.getWitnesses().contains(this)) {
      throw new WitnessTestimonyException("The witness does not belong to the case");
    }
    if (!legalCase.getStatus().equals(CaseStatus.IN_PROGRESS)) {
      throw new LegalCaseStatusException("The status of the case is not in process");
    }
    testifyFunction.testify(this, legalCase);
  }
}
