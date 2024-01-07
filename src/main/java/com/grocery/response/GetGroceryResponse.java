package com.grocery.response;

import com.grocery.lib.Grocery;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Response body for get grocery details
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@Setter
@Getter
public class GetGroceryResponse {
    List<Grocery> groceries = null;
    Status status = null;
}
