package com.grocery.services;

import com.grocery.body.BookGroceryBody;
import com.grocery.exceptions.QPGroceryNotFoundException;
import com.grocery.lib.Grocery;
import com.grocery.body.GroceryBody;
import com.grocery.lib.GroceryBooking;
import com.grocery.lib.GroceryDetails;
import com.grocery.repositories.GroceryBookingRepository;
import com.grocery.repositories.GroceryDetailsRepository;
import com.grocery.repositories.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *Performs CRUD operations related to groceries
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@Service
public class GroceryServiceImpl implements GroceryService{

    @Autowired
    private GroceryRepository groceryRepository;

    @Autowired
    private GroceryBookingRepository groceryBookingRepository;

    @Autowired
    private GroceryDetailsRepository groceryDetailsRepository;
    @Override
    public void addGroceryItems(GroceryBody groceries) {
        for (Grocery gr : groceries.getGroceries()) {
            Grocery grocery = new Grocery();
            grocery.setId(grocery.generateId());
            grocery.setName(gr.getName());
            grocery.setPrice(gr.getPrice());
            groceryRepository.save(grocery);
        }
    }

    @Override
    public List<Grocery> getGrocery() {
        return groceryRepository.findAll();
    }

    @Override
    public void deleteGrocery(String groceryId) {
        groceryRepository.deleteById(groceryId);
    }

    @Override
    public Grocery getGrocery(String groceryId) {
        Optional<Grocery> grocery = groceryRepository.findById(groceryId);
        return grocery.orElseThrow(() -> new QPGroceryNotFoundException("Grocery details not found with respect to grocery id."));
    }

    @Override
    public void updateGrocery(Grocery grocery, String name, Long price) {
        grocery.setName(name);
        grocery.setPrice(price);
        groceryRepository.save(grocery);
    }

    @Override
    public void bookGroceries(BookGroceryBody groceries) {
        for (String groceryId: groceries.getGroceriesId()){
            Grocery grocery = getGrocery(groceryId);
            GroceryBooking groceryBooking = new GroceryBooking();
            groceryBooking.setId(grocery.generateId());
            groceryBooking.setGroceryId(grocery.getId());
            groceryBooking.setUserId(groceries.getUserId());
            groceryBookingRepository.save(groceryBooking);
        }
    }

    @Override
    public List<GroceryDetails> searchByName(String groceryName) {
       return groceryDetailsRepository.findByName(groceryName);
    }


}
