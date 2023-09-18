package org.example.entities;

import org.example.service.Warehouse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void productWithNegIdReturnFalse () {
        Product p = null;
        Warehouse w = new Warehouse();
        Product p1 = new Product(0, "Motorcycle", Category.VEHICLES, -1, new Date(), new Date());
        Product p2 = new Product(0, "Car", Category.VEHICLES, -6, new Date(), new Date());
        assertFalse(Utils.isValid(p1));
        assertFalse(Utils.isValid(p2));
    }

    @Test
    void prodWithValidRatingReturnTrue () {
        Product p1 = new Product(0, "Motorcycle", Category.VEHICLES, 0, new Date(), new Date());
        Product p2 = new Product(0, "Boat", Category.VEHICLES, 4, new Date(), new Date());
        Product p3 = new Product(0, "Car", Category.VEHICLES, 10, new Date(), new Date());
        Warehouse w = new Warehouse();
        assertEquals(true, Utils.isValid(p1));
        assertEquals(true, Utils.isValid(p2));
        assertEquals(true, Utils.isValid(p3));
    }

}