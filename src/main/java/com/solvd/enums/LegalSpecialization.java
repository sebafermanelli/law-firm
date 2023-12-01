package com.solvd.enums;

public enum LegalSpecialization {
  CIVIL_COMMERCIAL_LAW("Civil And Commercial Law"),
  FAMILY_LAW("Family Law"),
  LABOR_LAW("Labor Law"),
  PENAL_LAW("Penal Law");

  private final String DESCRIPTION;

  LegalSpecialization(String DESCRIPTION) {
    this.DESCRIPTION = DESCRIPTION;
  }

  public String getDESCRIPTION() {
    return DESCRIPTION;
  }
}
