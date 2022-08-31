package com.example.trees.element.leaf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpruceNeedleTests {

    @Test
    @DisplayName("Test if SpruceNeedle is created with proper size.")
    public void spruceNeedleCreateTest() {
        SpruceNeedle leaf = new SpruceNeedle();
        Assertions.assertEquals(leaf.getSize(), 0);
    }

    @Test
    @DisplayName("Test if grow function of SpruceNeedle works correctly.")
    public void spruceNeedleGrowTest() {
        SpruceNeedle leaf = new SpruceNeedle();
        leaf.grow();
        Assertions.assertTrue(leaf.getSize() > 0);
    }
}
