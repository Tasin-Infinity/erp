package com.brainstation23.erp.mapper;

import com.brainstation23.erp.model.domain.Admin;
import com.brainstation23.erp.model.dto.admin.AdminResponse;
import com.brainstation23.erp.persistence.entity.AdminEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    @Mapping(target = "email", source = "userEntity.email")
    @Mapping(target = "userRole", source = "userEntity.userRole")
    Admin entityToDomain(AdminEntity entity);

    AdminResponse domainToResponse(Admin admin);
}