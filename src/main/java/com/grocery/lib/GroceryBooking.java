package com.grocery.lib;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity class for persisting booking of the grocery
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@Getter
@Setter
@Entity
@Table(name = "grocery_booking")
public class GroceryBooking {
    @Id
    private String id;

    @Column(name = "grocery_id")
    private String groceryId;
    @Column(name = "user_id")
    private String userId;

    private String payment;
}
