package com.solvd.classes;

import com.solvd.enums.DocumentType;

import java.util.Date;
import java.util.Objects;

public class LegalDocument {
  private DocumentType documentType;
  private Date creationDate;

  public LegalDocument(DocumentType documentType, Date creationDate) {
    this.documentType = documentType;
    this.creationDate = creationDate;
  }

  public DocumentType getDocumentType() {
    return documentType;
  }

  public void setDocumentType(DocumentType documentType) {
    this.documentType = documentType;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  @Override
  public String toString() {
    return "LegalDocument{" +
            "documentType='" + documentType + '\'' +
            ", creationDate=" + creationDate +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LegalDocument that = (LegalDocument) o;
    return Objects.equals(getDocumentType(), that.getDocumentType()) && Objects.equals(getCreationDate(), that.getCreationDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getDocumentType(), getCreationDate());
  }
}
