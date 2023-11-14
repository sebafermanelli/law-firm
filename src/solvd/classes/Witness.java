package solvd.classes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.exceptions.WitnessTestimonyException;
import solvd.interfaces.WitnessTestimony;

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
    System.out.println("Witness Information: " + toString());
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
  public void provideTestimony(LegalCase legalCase) throws WitnessTestimonyException {
//    Verificar que el testigo sea parte del caso, de lo contrario que no pueda testificar
    if(true) {
      LOGGER.info("Witness providing a testimony on the case");
    } else {
      throw new WitnessTestimonyException("Error in testimony process");
    }
  }
}
