package com.brainstation23.erp.model.dto.admin;

import com.brainstation23.erp.enums.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@ToString
@Getter
@Setter
public class AdminResponse {
    @Schema(description = "Organization ID", example = "3F41A301-25ED-4F0F-876F-7657BEABB00F")
    private UUID id;

    @Schema(description = "Admin First Name", example = "Jon")
    private String firstName;

    @Schema(description = "Admin Last Name", example = "Sina")
    private String lastName;

    @Schema(description = "Admin Email Name", example = "jon@gmail.com")
    private String email;

    @Schema(description = "Admin Role Name", example = "ADMIN")
    private UserRole userRole;
}