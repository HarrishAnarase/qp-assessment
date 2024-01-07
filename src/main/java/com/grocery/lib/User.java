package com.grocery.lib;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class for user details
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@Entity
@Table(name = "user_details")
@Getter
@Setter
public class User {
    @Id
    @NotBlank
    private String id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole staffRole;

    @NotNull
    private String name;

    @NotNull
    private String password;

}
