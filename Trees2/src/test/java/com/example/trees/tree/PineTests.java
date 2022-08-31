package com.example.trees.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PineTests {
    @Test
    @DisplayName("Test if Pine is created properly.")
    public void pineCreateTest() {
        Pine pine = new Pine();
        Assertions.assertEquals(pine.getAge(), 0);
        Assertions.assertEquals(pine.getSpecies(), "Pine");
        Assertions.assertNull(pine.getTrunk());
    }

    @Test
    @DisplayName("Test if Pine initiates properly.")
    public void pineInitTest() {
        Pine pine = new Pine();
        pine.init();
        Assertions.assertNotNull(pine.getTrunk());
    }

    @Test
    @DisplayName("Test if pine growing changes age.")
    public void pineGrowTest() {
        Pine pine = new Pine();
        pine.init();
        pine.grow();
        Assertions.assertTrue(pine.getAge() > 0);
    }

    @Test
    @DisplayName("Test if pine grows branches correctly.")
    public void pineGrowBranchesTest() {
        Pine pine = new Pine();
        pine.init();
        Assertions.assertFalse(pine.hasBranches());
        pine.grow();
        Assertions.assertTrue(pine.hasBranches());
    }

    @Test
    @DisplayName("Test if pine grows leaves correctly.")
    public void pineGrowLeavesTest() {
        Pine pine = new Pine();
        pine.init();
        pine.grow();
        Assertions.assertTrue(pine.hasBranches());
        Assertions.assertFalse(pine.hasLeaves());
        pine.grow();
        Assertions.assertTrue(pine.hasLeaves());
    }
}
