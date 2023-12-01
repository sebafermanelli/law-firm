package com.solvd.classes;

import com.solvd.enums.DocumentStatus;
import com.solvd.enums.DocumentType;
import com.solvd.interfaces.functional.StatusUpdaterFunction;
import com.solvd.interfaces.functional.TypeUpdaterFunction;

import java.util.Date;
import java.util.Objects;

public class LegalDocument {
  private DocumentType documentType;
  private Date creationDate;
  private DocumentStatus documentStatus;

  public LegalDocument(DocumentType documentType, Date creationDate, DocumentStatus documentStatus) {
    this.documentType = documentType;
    this.creationDate = creationDate;
    this.documentStatus = documentStatus;
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

  public DocumentStatus getDocumentStatus() {
    return documentStatus;
  }

  public void setDocumentStatus(DocumentStatus documentStatus) {
    this.documentStatus = documentStatus;
  }

  @Override
  public String toString() {
    return "LegalDocument{" +
            "documentType=" + documentType +
            ", creationDate=" + creationDate +
            ", documentStatus=" + documentStatus +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LegalDocument that = (LegalDocument) o;
    return getDocumentType() == that.getDocumentType() && Objects.equals(getCreationDate(), that.getCreationDate()) && getDocumentStatus() == that.getDocumentStatus();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getDocumentType(), getCreationDate(), getDocumentStatus());
  }

  public void changeDocumentStatus(DocumentStatus status, StatusUpdaterFunction<DocumentStatus> function) {
    function.changeStatus(status);
  }

  public void changeDocumentType(DocumentType type, TypeUpdaterFunction<DocumentType> function) {
    function.changeType(type);
  }
}
