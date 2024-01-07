package com.grocery.lib;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

/**
 * Entity class to store grocery details
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@Entity
@Table(name = "grocery")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Grocery {
    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private Long price;

    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
