package com.solvd.enums;

public enum CaseType {
  CIVIL_COMMERCIAL("Civil And Commercial Case", LegalSpecialization.CIVIL_COMMERCIAL_LAW, CourtType.CIVIL_COMMERCIAL_LAW),
  FAMILY("Family Case", LegalSpecialization.FAMILY_LAW, CourtType.FAMILY_LAW),
  LABOR("Labor Case", LegalSpecialization.LABOR_LAW, CourtType.LABOR_LAW),
  PENAL("Penal Case", LegalSpecialization.PENAL_LAW, CourtType.PENAL_LAW);

  private final String DESCRIPTION;
  private final LegalSpecialization LEGAL_SPECIALIZATION;
  private final CourtType COURT_TYPE;

  CaseType(String DESCRIPTION, LegalSpecialization LEGAL_SPECIALIZATION, CourtType COURT_TYPE) {
    this.DESCRIPTION = DESCRIPTION;
    this.LEGAL_SPECIALIZATION = LEGAL_SPECIALIZATION;
    this.COURT_TYPE = COURT_TYPE;
  }

  public String getDESCRIPTION() {
    return DESCRIPTION;
  }

  public LegalSpecialization getLEGAL_SPECIALIZATION() {
    return LEGAL_SPECIALIZATION;
  }

  public CourtType getCOURT_TYPE() {
    return COURT_TYPE;
  }
}
