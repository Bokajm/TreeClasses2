package com.example.trees.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpruceTests {
    @Test
    @DisplayName("Test if Spruce is created properly.")
    public void spruceCreateTest() {
        Spruce spruce = new Spruce();
        Assertions.assertEquals(spruce.getAge(), 0);
        Assertions.assertEquals(spruce.getSpecies(), "Spruce");
        Assertions.assertNull(spruce.getTrunk());
    }

    @Test
    @DisplayName("Test if Spruce initiates properly.")
    public void spruceInitTest() {
        Spruce spruce = new Spruce();
        spruce.init();
        Assertions.assertNotNull(spruce.getTrunk());
    }

    @Test
    @DisplayName("Test if spruce growing changes age.")
    public void spruceGrowTest() {
        Spruce spruce = new Spruce();
        spruce.init();
        spruce.grow();
        Assertions.assertTrue(spruce.getAge() > 0);
    }

    @Test
    @DisplayName("Test if spruce grows branches correctly.")
    public void spruceGrowBranchesTest() {
        Spruce spruce = new Spruce();
        spruce.init();
        Assertions.assertFalse(spruce.hasBranches());
        spruce.grow();
        Assertions.assertTrue(spruce.hasBranches());
    }

    @Test
    @DisplayName("Test if spruce grows leaves correctly.")
    public void spruceGrowLeavesTest() {
        Spruce spruce = new Spruce();
        spruce.init();
        spruce.grow();
        Assertions.assertTrue(spruce.hasBranches());
        Assertions.assertFalse(spruce.hasLeaves());
        spruce.grow();
        Assertions.assertTrue(spruce.hasLeaves());
    }
}
