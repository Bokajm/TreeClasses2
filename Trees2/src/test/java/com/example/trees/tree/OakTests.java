package com.example.trees.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OakTests {
    @Test
    @DisplayName("Test if Oak is created properly.")
    public void oakCreateTest() {
        Oak oak = new Oak();
        Assertions.assertEquals(oak.getAge(), 0);
        Assertions.assertEquals(oak.getSpecies(), "Oak");
        Assertions.assertNull(oak.getTrunk());
    }

    @Test
    @DisplayName("Test if Oak initiates properly.")
    public void oakInitTest() {
        Oak oak = new Oak();
        oak.init();
        Assertions.assertNotNull(oak.getTrunk());
    }

    @Test
    @DisplayName("Test if oak growing changes age.")
    public void oakGrowTest() {
        Oak oak = new Oak();
        oak.init();
        oak.grow();
        Assertions.assertTrue(oak.getAge() > 0);
    }

    @Test
    @DisplayName("Test if oak grows branches correctly.")
    public void oakGrowBranchesTest() {
        Oak oak = new Oak();
        oak.init();
        Assertions.assertFalse(oak.hasBranches());
        oak.grow();
        Assertions.assertTrue(oak.hasBranches());
    }

    @Test
    @DisplayName("Test if oak grows leaves correctly.")
    public void oakGrowLeavesTest() {
        Oak oak = new Oak();
        oak.init();
        oak.grow();
        Assertions.assertTrue(oak.hasBranches());
        Assertions.assertFalse(oak.hasLeaves());
        oak.growLeaves();
        Assertions.assertTrue(oak.hasLeaves());
    }

    @Test
    @DisplayName("Test if oak drops leaves correctly.")
    public void oakDropLeavesTest() {
        Oak oak = new Oak();
        oak.init();
        oak.grow();
        Assertions.assertTrue(oak.hasBranches());
        oak.growLeaves();
        Assertions.assertTrue(oak.hasLeaves());
        oak.dropLeaves();
        Assertions.assertFalse(oak.hasLeaves());
    }

    @Test
    @DisplayName("Test full oak grow cycle.")
    public void oakGrowCycleTest() {
        Oak oak = new Oak();
        oak.init();
        oak.grow();
        Assertions.assertTrue(oak.hasBranches());
        Assertions.assertFalse(oak.hasLeaves());

        oak.grow();
        oak.grow();
        oak.grow();
        Assertions.assertTrue(oak.hasLeaves());

        oak.grow();
        oak.grow();
        oak.grow();
        Assertions.assertFalse(oak.hasLeaves());
    }
}
