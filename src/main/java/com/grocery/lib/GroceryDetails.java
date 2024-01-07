package com.grocery.lib;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Entity class to mapp with database view
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@Getter
@Setter
@Entity
@ConfigurationProperties("grocerydetails")
@Table(name = "GroceryDetails")
public class GroceryDetails {
    @Id
    @NotBlank

    private String id;
    private String name;
    private Long price;

    private String user;

    private String payment;
}
