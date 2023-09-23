package org.example.service;

import org.example.entities.Category;
import org.example.entities.ProductRecord;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WarehouseTest {

    @Test
    void addProductWithEmptyNameReturnFalse() {
        ProductRecord p = new ProductRecord(0, "", Category.VEHICLES, 0, new Date(), new Date());
        Warehouse w = new Warehouse();
        assertEquals(false, w.addProduct(p));
    }

    @Test
    void addProductWithNullReferenceReturnFalse() {
        ProductRecord p = null;
        Warehouse w = new Warehouse();
        assertEquals(false, w.addProduct(p));
    }

    @Test
    void addProductWithANameNotEmptyReturnTrue() {
        ProductRecord p = new ProductRecord(0, "Motorcycle", Category.VEHICLES, 0, new Date(), new Date());
        Warehouse w = new Warehouse();
        assertEquals(true, w.addProduct(p));
    }

    @Test
    void addProductWithRatingHigherThan10ReturnFalse() {
        ProductRecord p1 = new ProductRecord(0, "Motorcycle", Category.VEHICLES, 11, new Date(), new Date());
        ProductRecord p2 = new ProductRecord(0, "Car", Category.VEHICLES, 13, new Date(), new Date());
        Warehouse w = new Warehouse();
        assertEquals(false, w.addProduct(p1));
        assertEquals(false, w.addProduct(p2));
    }

    @Test
    void addProductWithNegativeRatingReturnFalse() {
        ProductRecord p1 = new ProductRecord(0, "Motorcycle", Category.VEHICLES, -1, new Date(), new Date());
        ProductRecord p2 = new ProductRecord(0, "Car", Category.VEHICLES, -6, new Date(), new Date());
        Warehouse w = new Warehouse();
        assertEquals(false, w.addProduct(p1));
        assertEquals(false, w.addProduct(p2));
    }

    @Test
    void addProductWithRatingBetween0And10ReturnTrue() {
        ProductRecord p1 = new ProductRecord(0, "Motorcycle", Category.VEHICLES, 0, new Date(), new Date());
        ProductRecord p2 = new ProductRecord(0, "Boat", Category.VEHICLES, 4, new Date(), new Date());
        ProductRecord p3 = new ProductRecord(0, "Car", Category.VEHICLES, 10, new Date(), new Date());
        Warehouse w = new Warehouse();
        assertEquals(true, w.addProduct(p1));
        assertEquals(true, w.addProduct(p2));
        assertEquals(true, w.addProduct(p3));
    }

    @Test
    void addProdWithNegIdReturnFalse() {
        ProductRecord p1 = new ProductRecord(-1, "Cat", Category.ANIMALS, 2, new Date(), new Date());
        Warehouse w = new Warehouse();
        assertEquals(false, w.addProduct(p1));
    }

    @Test
    void addProdWithPosIdReturnTrue() {
        ProductRecord p1 = new ProductRecord(2, "Cat", Category.ANIMALS, 2, new Date(), new Date());
        Warehouse w = new Warehouse();
        assertEquals(true, w.addProduct(p1));
    }

    @Test
    void addProdWithTheSameNameReturnFalse() {
        ProductRecord p1 = new ProductRecord(1, "Bird", Category.ANIMALS, 5, new Date(), new Date());
        ProductRecord p2 = new ProductRecord(2, "birD", Category.ANIMALS, 3, new Date(), new Date());
        Warehouse w = new Warehouse();
        assertEquals(true, w.addProduct(p1));
        assertEquals(false, w.addProduct(p2));
    }

    @Test
    void modifyNullProductReturnFalse() {
        ProductRecord p = null;
        Warehouse w = new Warehouse();
        assertEquals(false, w.modifyProduct(p));
    }

    @Test
    void modifyNonExistingProductReturnFalse() {
        ProductRecord p = new ProductRecord(1, "hoRsE", Category.ANIMALS, 5, new Date(), new Date());
        Warehouse w = new Warehouse();
        assertEquals(false, w.modifyProduct(p));
    }

    @Test
    void modifyExistingObjectReturnTrue() {
        ProductRecord p1 = new ProductRecord(1, "hoRsE", Category.ANIMALS, 5, new Date(), new Date());
        ProductRecord p2 = new ProductRecord(1, "HOrSE", Category.VEHICLES, 3, new Date(), new Date());
        Warehouse w = new Warehouse();

        w.addProduct(p1);
        assertEquals(true, w.modifyProduct(p2));
    }

    @Test
    void getUnmodifiableListOfProductsThatWereAddedToTheList() {
        Warehouse w = new Warehouse();
        ProductRecord p1 = new ProductRecord(4, "Cow", Category.ANIMALS, 5, new Date(), new Date());
        ProductRecord p2 = new ProductRecord(1, "Airplane", Category.VEHICLES, 3, new Date(), new Date());
        ProductRecord p3 = new ProductRecord(2, "Jeans", Category.CLOTHES, 0, new Date(), new Date());
        w.addProduct(p1);
        w.addProduct(p2);
        w.addProduct(p3);

        assertThat(w.getAllProducts())
                .as("Should contain the three objects added above as an unmodifiable list")
                .hasSize(3)
//                .contains(p1, p2, p3)
                .isUnmodifiable();
    }

    @Test
    void getAnEmptyModifiableList() {
        Warehouse w = new Warehouse();
        assertThat(w.getAllProducts())
                .as("Should return an empty list of no objects have been added")
                .isUnmodifiable()
                .isEmpty();
    }

    @Test
    void getProductWithCorrectProductID() {
        Warehouse w = new Warehouse();
        ProductRecord p1 = new ProductRecord(4, "Cow", Category.ANIMALS, 5, new Date(), new Date());
        ProductRecord p2 = new ProductRecord(1, "Airplane", Category.VEHICLES, 3, new Date(), new Date());
        ProductRecord p3 = new ProductRecord(2, "Jeans", Category.CLOTHES, 7, new Date(), new Date());
        ProductRecord p4 = new ProductRecord(5, "Shirt", Category.CLOTHES, 5, new Date(), new Date());

        w.addProduct(p1);
        w.addProduct(p2);
        w.addProduct(p3);
        w.addProduct(p4);

        assertThat(w.getProduct(2).orElse(null))
                .as("Should return optional containing object p3")
                .isNotSameAs(p3)
                .isEqualTo(p3);
    }

    @Test
    void getProductWithInvalidProductID() {
        Warehouse w = new Warehouse();
        ProductRecord p1 = new ProductRecord(4, "Cow", Category.ANIMALS, 5, new Date(), new Date());
        ProductRecord p2 = new ProductRecord(1, "Airplane", Category.VEHICLES, 3, new Date(), new Date());
        ProductRecord p3 = new ProductRecord(2, "Jeans", Category.CLOTHES, 7, new Date(), new Date());
        ProductRecord p4 = new ProductRecord(5, "Shirt", Category.CLOTHES, 5, new Date(), new Date());

        w.addProduct(p1);
        w.addProduct(p2);
        w.addProduct(p3);
        w.addProduct(p4);

        assertThat(w.getProduct(3))
                .as("Should return an empty optional")
                .isEmpty()
                .isNotPresent();
    }

}