package com.brainstation23.erp.mapper;

import com.brainstation23.erp.model.domain.User;
import com.brainstation23.erp.model.dto.user.UserResponse;
import com.brainstation23.erp.persistence.entity.UserEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    @Mapping(target = "employee", source = "employeeEntity")
    User entityToDomain(UserEntity entity);

    @Mapping(target = "employeeResponse", source = "employee")
    UserResponse domainToResponse(User user);
}
