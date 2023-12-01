package com.solvd.enums;

public enum DocumentType {
  BREACH_CONTRACT("Breach Contract", CaseType.CIVIL_COMMERCIAL),
  TRAFFIC_ACCIDENT("Traffic Accident", CaseType.CIVIL_COMMERCIAL),
  REAL_ESTATE("Real Estate", CaseType.CIVIL_COMMERCIAL),
  LEASING("Leasing", CaseType.CIVIL_COMMERCIAL),
  NATIONALITY("Nationality", CaseType.CIVIL_COMMERCIAL),
  EVICTION("Eviction", CaseType.CIVIL_COMMERCIAL),
  USUCAPTION("Usucaption", CaseType.CIVIL_COMMERCIAL),

  DIVORCE("Divorce", CaseType.FAMILY),
  SUCCESSION("Succession", CaseType.FAMILY),
  DOMESTIC_VIOLENCE("Domestic Violence", CaseType.FAMILY),
  FILIATION("Filiation", CaseType.FAMILY),
  FOOD_TENURE_VISITATION_REGIME("Food And Tenure Visitation Regime", CaseType.FAMILY),
  ADOPTION("Adoption", CaseType.FAMILY),

  DISMISSAL("Dismissal", CaseType.LABOR),
  ACCIDENT("Labor Accident", CaseType.LABOR),
  PROTECTION("Labor Protection", CaseType.LABOR),
  WAGE_DIFFERENCE("Wage Difference", CaseType.LABOR),

  FRAUD("Fraud", CaseType.PENAL),
  THEFT("Theft", CaseType.PENAL),
  ROBBERY("Robbery", CaseType.PENAL),
  ATTEMPTED_HOMICIDE("Attempted Homicide", CaseType.PENAL),
  HOMICIDE("Homicide", CaseType.PENAL),
  CAPITAL_BLOCKADE("Capital Blockade", CaseType.PENAL);

  private final String DESCRIPTION;
  private final CaseType CASE_TYPE;

  DocumentType(String DESCRIPTION, CaseType CASE_TYPE) {
    this.DESCRIPTION = DESCRIPTION;
    this.CASE_TYPE = CASE_TYPE;
  }

  public String getDESCRIPTION() {
    return DESCRIPTION;
  }

  public CaseType getCASE_TYPE() {
    return CASE_TYPE;
  }
}
