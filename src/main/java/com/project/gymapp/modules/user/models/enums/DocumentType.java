package com.project.gymapp.modules.user.models.enums;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public enum DocumentType {
    RG,
    @CPF
    CPF,
    @CNPJ
    CNPJ,
    CNH
}
