package com.grocery.body;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Harrish Anarase
 * @RequestBody for @PostMapping("/login")
 * @since 2024
 * @version 1.0
 */
@Getter
@Setter
public class UserLoginBody {
    private String userName = null;

    //Used char array to avoid security threat
    private char[] password = null;
}
