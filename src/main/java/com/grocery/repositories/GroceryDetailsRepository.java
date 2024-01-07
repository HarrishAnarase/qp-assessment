package com.grocery.repositories;

import com.grocery.lib.GroceryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DAO for interacting with database related GroceryDetails
 * @author Harrish Anarase
 * @since 2024
 * @version 1.0
 */
@Repository
public interface GroceryDetailsRepository extends JpaRepository<GroceryDetails, String> {
//    @Query(value =" SELECT `g`.`id` AS `id`,`g`.`name` AS `name`, `g`.`price` AS `price`, `ud`.`name` AS `userName`,`gb`.`payment` AS `paymentStatus` from (((`qp-assessment`.`grocery` `g` LEFT JOIN `qp-assessment`.`grocery_booking` `gb` ON ((`g`.`id` = `gb`.`grocery_id`))) LEFT JOIN `qp-assessment`.`user_details` `ud` ON ((`gb`.`user_id` = `ud`.`id`))))  where `g`.`name`=?1", nativeQuery = true)
    @Query(value =" SELECT * FROM `qp-assessment`.grocerydetails where name=?1", nativeQuery = true)
    public List<GroceryDetails> findByName(String groceryName);
}
