package com.brainstation23.erp.service;

import com.brainstation23.erp.enums.UserRole;
import com.brainstation23.erp.exception.custom.custom.NotFoundException;
import com.brainstation23.erp.mapper.EmployeeMapper;
import com.brainstation23.erp.model.domain.User;
import com.brainstation23.erp.model.dto.user.employee.CreateEmployeeRequest;
import com.brainstation23.erp.model.dto.user.employee.UpdateEmployeeRequest;
import com.brainstation23.erp.persistence.entity.EmployeeEntity;
import com.brainstation23.erp.persistence.entity.UserEntity;
import com.brainstation23.erp.persistence.repository.EmployeeRepository;
import com.brainstation23.erp.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmployeeService {
    public static final String EMPLOYEE_NOT_FOUND = "Employee Not Found";
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final PasswordEncoder passwordEncoder;

    public Page<User> getAll(Pageable pageable) {
        var entities = userRepository.findAll(pageable);
        return entities.map(employeeMapper::entityToDomain);
    }

    public User getOne(UUID id) {
        var entity = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EMPLOYEE_NOT_FOUND));
        return employeeMapper.entityToDomain(entity);
    }

    public UUID createOne(CreateEmployeeRequest createRequest) {
        var userEntity = new UserEntity();
        String encodedPassword = passwordEncoder.encode(createRequest.getPassword());
        userEntity.setId(UUID.randomUUID())
                .setEmail(createRequest.getEmail())
                .setPassword(encodedPassword) // TODO: apply encryption
                .setUserRole(UserRole.EMPLOYEE)
                .setAdminEntity(null);

        var createdUserEntity = userRepository.save(userEntity);

        var employeeEntity = new EmployeeEntity();
        employeeEntity.setId(UUID.randomUUID())
                .setFirstName(createRequest.getFirstName())
                .setLastName(createRequest.getLastName())
                .setAccountBalance(createRequest.getAccountBalance())
                .setUserEntity(createdUserEntity);
        var createdEmployeeEntity = employeeRepository.save(employeeEntity);

        return createdUserEntity.getId();
    }

    public void updateOne(UUID id, UpdateEmployeeRequest updateRequest) {
        var userEntity = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EMPLOYEE_NOT_FOUND));
        var employeeEntity = employeeRepository.findByUserEntity(userEntity)
                .orElseThrow(() -> new NotFoundException(EMPLOYEE_NOT_FOUND));
        employeeEntity.setFirstName(updateRequest.getFirstName())
                .setLastName(updateRequest.getLastName())
                .setAccountBalance(updateRequest.getAccountBalance());
        employeeRepository.save(employeeEntity);
    }

    public void deleteOne(UUID id) {
        var userEntity = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(EMPLOYEE_NOT_FOUND));
        employeeRepository.deleteById(userEntity.getEmployeeEntity().getId());
        userRepository.deleteById(userEntity.getId());
    }

}