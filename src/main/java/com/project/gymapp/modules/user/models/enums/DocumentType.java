package com.project.gymapp.modules.user.models.enums;

public enum DocumentType {
    RG("rg"),
    CPF("cpf"),
    CNPJ("cnpj"),
    CNH("cnh");

    private final String documentType;

    DocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }
}
