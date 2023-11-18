package org.solvd.classes;

import java.util.Objects;

public class Client extends Person {
  private String contactInfo;

  public Client(String name, String contactInfo) {
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
  public String toString() {
    return "Client{" +
            "contactInfo='" + contactInfo + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Client client = (Client) o;
    return Objects.equals(getContactInfo(), client.getContactInfo());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getContactInfo());
  }

  @Override
  public void displayPersonInfo() {
    System.out.println("Client Information: " + toString());
  }
}
