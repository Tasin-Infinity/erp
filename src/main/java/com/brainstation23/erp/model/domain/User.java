package com.brainstation23.erp.model.domain;

import com.brainstation23.erp.constant.EntityConstant;
import com.brainstation23.erp.enums.UserRole;
import com.brainstation23.erp.persistence.entity.AdminEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = EntityConstant.USER)
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private UUID id;
    private String email;
    private String password;
    private UserRole userRole;
    private AdminEntity adminEntity;
}