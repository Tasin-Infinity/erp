package com.brainstation23.erp.model.dto.user.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Getter
@Setter
public class UpdateEmployeeRequest {
    @Schema(description = "Employee First Name", example = "Jon")
    private String firstName;

    @Schema(description = "Employee Last Name", example = "Sina")
    private String lastName;

    @Schema(description = "Employee Account Balance", example = "10000")
    private Double accountBalance;
}