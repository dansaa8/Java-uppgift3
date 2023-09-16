package org.example.service;

import org.example.entities.Category;
import org.example.entities.Product;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarehouseTest {

    @Test
    void givenProductWithEmptyNameReturnFalse() {
        Product p = new Product(0, "", Category.VEHICLES, 0, new Date(), new Date());
        Warehouse w = new Warehouse();
        assertEquals(false, w.addProduct(p));
    }

//    @Test
//    void addProduct() {
//        Product p = new Product(0, "Motorcycle", Category.VEHICLES, 0, new Date(), new Date());
//        Warehouse w = new Warehouse();
//        assertEquals(w.addProduct("Motorcycle"), true);
//    }

}