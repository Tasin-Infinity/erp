package com.brainstation23.erp.persistence.entity;

import com.brainstation23.erp.constant.EntityConstant;
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
public class AdminEntity {
    @Id
    @Type(type = "uuid-char")
    private UUID id;
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}