package com.grocery.body;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Harrish Anarase
 * @RequestBody for  @PostMapping("/book-groceries")
 * @since 2024
 * @version 1.0
 */
@Getter
@Setter
public class BookGroceryBody {
    private List<String> groceriesId;
    private String userId;
}
