package com.brainstation23.erp.model.dto.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
public class UpdateAdminRequest {
    @Schema(description = "Admin First Name", example = "Jon")
    private String firstName;

    @Schema(description = "Admin Last Name", example = "Sina")
    private String lastName;
}