package com.brainstation23.erp.service;

import com.brainstation23.erp.enums.UserRole;
import com.brainstation23.erp.exception.custom.custom.NotFoundException;
import com.brainstation23.erp.mapper.AdminMapper;
import com.brainstation23.erp.model.domain.Admin;
import com.brainstation23.erp.model.dto.admin.CreateAdminRequest;
import com.brainstation23.erp.model.dto.admin.UpdateAdminRequest;
import com.brainstation23.erp.persistence.entity.AdminEntity;
import com.brainstation23.erp.persistence.entity.UserEntity;
import com.brainstation23.erp.persistence.repository.AdminRepository;
import com.brainstation23.erp.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminService {
    public static final String ORGANIZATION_NOT_FOUND = "Admin Not Found";
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public Page<Admin> getAll(Pageable pageable) {
        var entities = adminRepository.findAll(pageable);
        return entities.map(adminMapper::entityToDomain);
    }

    public Admin getOne(UUID id) {
        var entity = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ORGANIZATION_NOT_FOUND));
        return adminMapper.entityToDomain(entity);
    }

    public UUID createOne(CreateAdminRequest createRequest) {
        var userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID())
                .setEmail(createRequest.getEmail())
                .setPassword(createRequest.getPassword())
                .setUserRole(UserRole.ADMIN);
        var createdUserEntity = userRepository.save(userEntity);

        var adminEntity = new AdminEntity();
        adminEntity.setId(UUID.randomUUID())
                .setFirstName(createRequest.getFirstName())
                .setLastName(createRequest.getLastName())
                .setUserEntity(createdUserEntity);
        var createdAdminEntity = adminRepository.save(adminEntity);

        return createdAdminEntity.getId();
    }

    public void updateOne(UUID id, UpdateAdminRequest updateRequest) {
        var entity = adminRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ORGANIZATION_NOT_FOUND));
        entity.setFirstName(updateRequest.getFirstName()).setLastName(updateRequest.getLastName());
        adminRepository.save(entity);
    }

    public void deleteOne(UUID id) {
        adminRepository.deleteById(id);
    }

}