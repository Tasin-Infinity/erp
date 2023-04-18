package com.brainstation23.erp.persistence.repository;

import com.brainstation23.erp.model.domain.User;
import com.brainstation23.erp.persistence.entity.EmployeeEntity;
import com.brainstation23.erp.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {
    Optional<EmployeeEntity> findByUserEntity(UserEntity entity);
}