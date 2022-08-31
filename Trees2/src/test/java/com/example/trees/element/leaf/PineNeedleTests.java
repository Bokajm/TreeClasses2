package com.example.trees.element.leaf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PineNeedleTests {

    @Test
    @DisplayName("Test if PineNeedle is created with proper size.")
    public void pineNeedleCreateTest() {
        PineNeedle leaf = new PineNeedle();
        Assertions.assertEquals(leaf.getSize(), 0);
    }

    @Test
    @DisplayName("Test if grow function of PineNeedle works correctly.")
    public void pineNeedleGrowTest() {
        PineNeedle leaf = new PineNeedle();
        leaf.grow();
        Assertions.assertTrue(leaf.getSize() > 0);
    }
}
