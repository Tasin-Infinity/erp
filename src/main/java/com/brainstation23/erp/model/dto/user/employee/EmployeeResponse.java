package com.brainstation23.erp.model.dto.user.employee;

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
public class EmployeeResponse {
    @Schema(description = "Employee ID", example = "3F41A301-25ED-4F0F-876F-7657BEABB00F")
    private UUID id;

    @Schema(description = "Employee First Name", example = "Jon")
    private String firstName;

    @Schema(description = "Employee Last Name", example = "Sina")
    private String lastName;

    @NotNull
    @Schema(description = "Employee Account Balance", example = "10000")
    private Double accountBalance;

}
