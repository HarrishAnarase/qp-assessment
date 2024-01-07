package com.grocery.repositories;

import com.grocery.lib.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO for interacting with database related grocery entries
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@Repository
public interface GroceryRepository extends JpaRepository<Grocery, String> {
}
