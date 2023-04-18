package com.brainstation23.erp.persistence.entity;

import com.brainstation23.erp.constant.EntityConstant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = EntityConstant.ADMIN)
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @Type(type = "uuid-char")
    private UUID id;
    private String firstName;
    private String lastName;
    private Double accountBalance;
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    @JsonIgnoreProperties("employeeEntity")
    private UserEntity userEntity;
}