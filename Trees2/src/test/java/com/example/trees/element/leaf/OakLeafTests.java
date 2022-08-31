package com.example.trees.element.leaf;

import com.example.trees.element.leaf.OakLeaf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OakLeafTests {

    @Test
    @DisplayName("Test if OakLeaf is created with proper size.")
    public void oakLeafCreateTest() {
        OakLeaf leaf = new OakLeaf();
        Assertions.assertEquals(leaf.getSize(), 0);
    }

    @Test
    @DisplayName("Test if grow function of OakLeaf works correctly.")
    public void oakLeafGrowTest() {
        OakLeaf leaf = new OakLeaf();
        leaf.grow();
        Assertions.assertTrue(leaf.getSize() > 0);
    }
}
