package com.brainstation23.erp.model.dto.user;

import com.brainstation23.erp.enums.UserRole;
import com.brainstation23.erp.model.dto.admin.AdminResponse;
import com.brainstation23.erp.model.dto.user.employee.EmployeeResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@Setter
public class UserResponse {
    @Schema(description = "User ID", example = "3F41A301-25ED-4F0F-876F-7657BEABB00F")
    private UUID id;
    @Schema(description = "User Email Address", example = "jon@gmail.com")
    private String email;
    @Schema(description = "User Role Name", example = "User")
    private UserRole userRole;
    @Schema(description = "Employee Response")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EmployeeResponse employeeResponse;
    @Schema(description = "Admin Response")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AdminResponse adminResponse;
}
