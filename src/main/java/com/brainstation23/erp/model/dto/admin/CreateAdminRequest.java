package com.brainstation23.erp.model.dto.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public class CreateAdminRequest {
    @NotNull
    @Schema(description = "Admin First Name", example = "Jon")
    private String firstName;

    @NotNull
    @Schema(description = "Admin Last Name", example = "Sina")
    private String lastName;

    @NotNull
    @Schema(description = "Admin Email Name", example = "jon@gmail.com")
    private String email;

    @NotNull
    @Schema(description = "Password", example = "cantseeme")
    private String password;

}