package com.project.gymapp.modules.user.models.dtos;

import com.project.gymapp.modules.user.models.Address;
import com.project.gymapp.modules.user.models.enums.DocumentType;

public record UserDTO(String name, String lastName, DocumentType documentType, String document, String email, Address address) {

}
