package com.grocery.controllers;

import com.grocery.body.BookGroceryBody;
import com.grocery.body.GroceryBody;
import com.grocery.exceptions.QPException;
import com.grocery.lib.Grocery;
import com.grocery.lib.UserRole;
import com.grocery.response.GetGroceryResponse;
import com.grocery.response.Status;
import com.grocery.response.StatusResponse;
import com.grocery.services.GroceryServiceImpl;
import com.grocery.util.Util;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller class used mapped API for grocery management
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@RestController
@Scope("request")
@RequestMapping(path = {"/grocery"}, produces = "application/json")
public class GroceryApiController {

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    @Autowired
    GroceryApiController(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        this.request = request;
        this.response = response;
    }

    @Autowired
    private GroceryServiceImpl service;

    @Autowired
    private Util util;

    /**
     * Add multiple number of grocery items
     * @param groceryBody
     * @return StatusResponse
     */
    @PostMapping("add-grocery")
    public ResponseEntity<StatusResponse> addGroceryItems(@Valid @RequestBody GroceryBody groceryBody) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            util.isUserLoggedIn(request, response, List.of(UserRole.ADMIN));
            service.addGroceryItems(groceryBody);
            statusResponse.setStatus(new Status("Grocery items added successfully."));

        } catch (QPException e) {
            statusResponse.setStatus(new Status(e.getMessage()));
        }
        return ResponseEntity.ok(statusResponse);
    }

    /**
     * Get grocery details
     * @return GetGroceryResponse
     */
    @GetMapping("/get-grocery")
    public ResponseEntity<GetGroceryResponse> getGrocery() {
        GetGroceryResponse getGroceryResponse = new GetGroceryResponse();
        try {
            util.isUserLoggedIn(request, response, List.of(UserRole.ADMIN, UserRole.USER));
            List<Grocery> groceries = service.getGrocery();
            getGroceryResponse.setGroceries(groceries);
            getGroceryResponse.setStatus(new Status("Grocery details fetched successfully."));
        } catch (QPException e) {
            getGroceryResponse.setStatus(new Status(e.getMessage()));
        }
        return ResponseEntity.ok(getGroceryResponse);
    }

    /**
     * Remove grocer item w. r. t. groceryId
     * @param groceryId
     * @return StatusResponse
     */
    @DeleteMapping("/remove-grocery/{groceryId}")
    public ResponseEntity<StatusResponse> deletGrocery(@Valid @PathVariable String groceryId) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            util.isUserLoggedIn(request, response, List.of(UserRole.ADMIN));
            service.deleteGrocery(groceryId);
            statusResponse.setStatus(new Status("Grocery removed successfully."));
        } catch (QPException e) {
            statusResponse.setStatus(new Status(e.getMessage()));
        }
        return ResponseEntity.ok(statusResponse);
    }

    /**
     * Update groceries details
     * @param body
     * @return StatusResponse
     */
    @PutMapping("/update-grocery-details")
    public ResponseEntity<StatusResponse> updateGroceryItems(@Valid @RequestBody Grocery body) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            util.isUserLoggedIn(request, response, List.of(UserRole.ADMIN));
            Grocery grocery = service.getGrocery(body.getId());
            service.updateGrocery(grocery, body.getName(), body.getPrice());
            statusResponse.setStatus(new Status("Grocery updated successfully."));
        } catch (QPException e) {
            statusResponse.setStatus(new Status(e.getMessage()));
        }
        return ResponseEntity.ok(statusResponse);
    }

    /**
     * Book number of grocery items
     * @param body
     * @return StatusResponse
     */
    @PostMapping("/book-groceries")
    public ResponseEntity<StatusResponse> bookGroceryItems(@Valid @RequestBody BookGroceryBody body) {
        StatusResponse statusResponse = new StatusResponse();
        try {
            util.isUserLoggedIn(request, response, List.of(UserRole.USER));
            service.bookGroceries(body);
            statusResponse.setStatus(new Status("Grocery/groceries booked successfully."));
        } catch (QPException e) {
            statusResponse.setStatus(new Status(e.getMessage()));
        }
        return ResponseEntity.ok(statusResponse);
    }


}