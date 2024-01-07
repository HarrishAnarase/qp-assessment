package com.grocery.services;

import com.grocery.body.BookGroceryBody;
import com.grocery.body.GroceryBody;
import com.grocery.lib.Grocery;
import com.grocery.lib.GroceryDetails;

import java.util.List;

/**
 * GroceryService interface
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
public interface GroceryService {
    void addGroceryItems(GroceryBody groceries);
    List<Grocery> getGrocery();
    void deleteGrocery(String groceryId);
    Grocery getGrocery(String groceryId);
    void updateGrocery(Grocery grocery, String name, Long price);
    void bookGroceries(BookGroceryBody groceries);
    List<GroceryDetails> searchByName(String groceryName);
}
