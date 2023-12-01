package com.solvd.enums;

public enum CourtType {
  CIVIL_COMMERCIAL_LAW("Civil And Commercial Law", LegalSpecialization.CIVIL_COMMERCIAL_LAW),
  FAMILY_LAW("Family Law", LegalSpecialization.FAMILY_LAW),
  LABOR_LAW("Labor Law", LegalSpecialization.LABOR_LAW),
  PENAL_LAW("Penal Law", LegalSpecialization.PENAL_LAW);

  private final String DESCRIPTION;
  private final LegalSpecialization JUDGE_SPECIALIZATION;

  CourtType(String DESCRIPTION, LegalSpecialization JUDGE_SPECIALIZATION) {
    this.DESCRIPTION = DESCRIPTION;
    this.JUDGE_SPECIALIZATION = JUDGE_SPECIALIZATION;
  }

  public String getDESCRIPTION() {
    return DESCRIPTION;
  }

  public LegalSpecialization getJUDGE_SPECIALIZATION() {
    return JUDGE_SPECIALIZATION;
  }
}
