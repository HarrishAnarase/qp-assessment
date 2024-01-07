package com.grocery.response;


import com.grocery.lib.GroceryDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Response body for get grocery details
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@Getter
@Setter
public class GetGroceryDetailResponse {
    List<GroceryDetails> groceries = null;
    Status status = null;
}

