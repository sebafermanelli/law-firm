package com.solvd.enums;

import java.util.EnumSet;

public enum DocumentStatus {
  DRAFT("Draft", EnumSet.allOf(DocumentType.class)),
  UNDER_REVIEW("Under Review", EnumSet.allOf(DocumentType.class)),
  APPROVED("Approved", EnumSet.allOf(DocumentType.class));

  private final String DESCRIPTION;
  private final EnumSet<DocumentType> DOCUMENT_TYPES;

  DocumentStatus(String DESCRIPTION, EnumSet<DocumentType> DOCUMENT_TYPES) {
    this.DESCRIPTION = DESCRIPTION;
    this.DOCUMENT_TYPES = DOCUMENT_TYPES;
  }

  public String getDESCRIPTION() {
    return DESCRIPTION;
  }

  public EnumSet<DocumentType> getDOCUMENT_TYPES() {
    return DOCUMENT_TYPES;
  }
  }
