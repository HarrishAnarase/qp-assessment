package com.grocery.services;

import com.grocery.lib.User;

/**
 * UserService interface
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
public interface UserService {
boolean isValidLogin(String user, char[] password);
   User getUserInstant(String user);
}
