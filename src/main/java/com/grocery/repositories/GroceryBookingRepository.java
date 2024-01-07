package com.grocery.repositories;

import com.grocery.lib.GroceryBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *DAO for interacting with database related grocery booking log
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@Repository
public interface GroceryBookingRepository extends JpaRepository<GroceryBooking, String> {
}
