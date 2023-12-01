package com.solvd.enums;

import java.util.EnumSet;

public enum CaseStatus {
  OPEN("Open", EnumSet.allOf(CaseType.class)),
  IN_PROGRESS("In Progress", EnumSet.allOf(CaseType.class)),
  CLOSED("Closed", EnumSet.allOf(CaseType.class)),
  ARCHIVED("Archived", EnumSet.allOf(CaseType.class));

  private final String DESCRIPTION;
  private final EnumSet<CaseType> CASE_TYPES;

  CaseStatus(String DESCRIPTION, EnumSet<CaseType> CASE_TYPES) {
    this.DESCRIPTION = DESCRIPTION;
    this.CASE_TYPES = CASE_TYPES;
  }

  public String getDESCRIPTION() {
    return DESCRIPTION;
  }

  public EnumSet<CaseType> getCASE_TYPES() {
    return CASE_TYPES;
  }
}
