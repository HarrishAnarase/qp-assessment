package com.grocery.body;

import com.grocery.lib.Grocery;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harrish Anarase
 * @RequestBody for @PostMapping("add-grocery")
 * @since 2024
 * @version 1.0
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroceryBody {
    @NotNull
    @NotEmpty
    List<Grocery> groceries = new ArrayList<>();
}
