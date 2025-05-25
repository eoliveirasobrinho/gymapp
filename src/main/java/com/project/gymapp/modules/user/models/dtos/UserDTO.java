package com.project.gymapp.modules.user.models.dtos;

import com.project.gymapp.modules.user.models.Address;
import com.project.gymapp.modules.user.models.enums.DocumentType;
import com.project.gymapp.modules.user.models.enums.Role;

public record UserDTO(String name, String lastName, DocumentType documentType, String document, String email, Address address, Boolean isActive, String username, String password, Role role) {

}
