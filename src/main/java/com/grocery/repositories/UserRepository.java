package com.grocery.repositories;

import com.grocery.lib.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * DAO for interacting with database related User
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT (CASE WHEN (STRCMP(user_details.password, SHA2(?2, 512)) = 0) THEN 1 ELSE 0 END) AS isValidLogin FROM user_details WHERE name = ?1 ", nativeQuery = true)
    int isValidLogin(String email, char[] password);

    public User findByName(String name);
}
