package com.brainstation23.erp.model.dto.user.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;


@ToString
@Getter
@Setter
public class CreateEmployeeRequest {
    @NotNull
    @Schema(description = "Employee First Name", example = "Jon")
    private String firstName;

    @NotNull
    @Schema(description = "Employee Last Name", example = "Sina")
    private String lastName;

    @NotNull
    @Schema(description = "Employee Email Address", example = "jon@gmail.com")
    private String email;

    @NotNull
    @Schema(description = "Employee Account Balance", example = "10000")
    private Double accountBalance;

    @NotNull
    @Schema(description = "Password", example = "cantseeme")
    private String password;

}
