package com.grocery.controllers;

import com.grocery.exceptions.QPException;
import com.grocery.lib.GroceryDetails;
import com.grocery.lib.UserRole;
import com.grocery.response.GetGroceryDetailResponse;
import com.grocery.response.GetGroceryResponse;
import com.grocery.response.Status;
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
 *  This controller class used mapped API for grocery inventory management
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@RestController
@Scope("request")
@RequestMapping(path = {"/admin"}, produces = "application/json")
public class GroceryInventoryApiController {

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    @Autowired
    GroceryInventoryApiController(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        this.request = request;
        this.response = response;
    }
    @Autowired
    private Util util;

    @Autowired
    private GroceryServiceImpl groceryService;

    /**
     * Search grocery w. r. t. name
     * @param groceryName
     * @return GetGroceryDetailResponse
     */
    @GetMapping("/search-grocery-by-name")
    public ResponseEntity<GetGroceryDetailResponse> searchByName(
            @Valid @RequestParam(value = "groceryName", required = true) String groceryName) {
        var getGroceryResponse = new GetGroceryDetailResponse();
        try {
            util.isUserLoggedIn(request, response, List.of(UserRole.ADMIN));

            List<GroceryDetails> groceryDetails = groceryService.searchByName(groceryName);
            getGroceryResponse.setGroceries(groceryDetails);
            getGroceryResponse.setStatus(new Status("Groceries fetched successfully."));
        } catch (QPException e) {
            getGroceryResponse.setStatus(new Status(e.getMessage()));
        }
        return ResponseEntity.ok(getGroceryResponse);
    }

    // Also we can get grocery details with respect to price or user by whom it is booked
    }


