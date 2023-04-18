package com.brainstation23.erp.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private UUID id;
    private String firstName;
    private String lastName;
    private Double accountBalance;
    private User user;
}
