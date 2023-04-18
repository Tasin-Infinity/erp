package com.brainstation23.erp.controller.rest;

import com.brainstation23.erp.mapper.EmployeeMapper;
import com.brainstation23.erp.model.dto.user.UserResponse;
import com.brainstation23.erp.model.dto.user.employee.CreateEmployeeRequest;
import com.brainstation23.erp.model.dto.user.employee.UpdateEmployeeRequest;
import com.brainstation23.erp.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "Employee")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeRestController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @Operation(summary = "Get All Employees")
    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(@ParameterObject Pageable pageable) {
        log.info("Getting List of Employees");
        var domains = employeeService.getAll(pageable);
        return ResponseEntity.ok(domains.map(employeeMapper::domainToResponse));
    }

    @Operation(summary = "Get Single Employee")
    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getOne(@PathVariable UUID id) {
        log.info("Getting Details of Employee({})", id);
        var domain = employeeService.getOne(id);
        return ResponseEntity.ok(employeeMapper.domainToResponse(domain));
    }

    @Operation(summary = "Create Single Employee")
    @PostMapping
    public ResponseEntity<Void> createOne(@RequestBody @Valid CreateEmployeeRequest createRequest) {
        log.info("Creating an Employee: {} ", createRequest);
        var id = employeeService.createOne(createRequest);
        var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Update Single Employee")
    @PutMapping("{id}")
    public ResponseEntity<Void> updateOne(@PathVariable UUID id,
                                          @RequestBody @Valid UpdateEmployeeRequest updateRequest) {
        log.info("Updating an Employee({}): {} ", id, updateRequest);
        employeeService.updateOne(id, updateRequest);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete Single Employee")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOne(@PathVariable UUID id) {
        log.info("Deleting an Employee({}) ", id);
        employeeService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }
}