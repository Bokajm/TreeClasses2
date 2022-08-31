package com.example.trees.element.trunk;

import com.example.trees.element.branch.AbstractBranch;
import com.example.trees.element.leaf.AbstractLeaf;
import com.example.trees.tree.AbstractTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrunkTests {
    private static class TestLeaf extends AbstractLeaf {
        public TestLeaf() {
            super("Test leaf");
        }
    }

    private static class TestBranch extends AbstractBranch<TestBranch, TestLeaf> {
        public TestBranch(TestTree tree) {
            super(tree);
        }
    }

    private static class TestTree extends AbstractTree<Trunk<TestBranch, TestLeaf>, TestBranch, TestLeaf> {

        public TestTree() {
            super("Test tree");
        }

        @Override
        public TestLeaf newLeaf() {
            return new TestLeaf();
        }

        @Override
        public TestBranch newBranch() {
            return new TestBranch(this);
        }

        @Override
        public Trunk<TestBranch, TestLeaf> newTrunk() {
            return new Trunk<>(this);
        }
    }

    @Test
    @DisplayName("Test if Trunk is created with proper size.")
    public void trunkCreateTest() {
        TestTree tree = new TestTree();

        Trunk<TestBranch, TestLeaf> trunk = new Trunk<>(tree);
        Assertions.assertEquals(trunk.getSize(), 0);
    }

    @Test
    @DisplayName("Test if grow function of Trunk changes size.")
    public void trunkGrowTest() {
        TestTree tree = new TestTree();

        Trunk<TestBranch, TestLeaf> trunk = new Trunk<>(tree);
        Assertions.assertEquals(trunk.getSize(), 0);
        trunk.grow();
        Assertions.assertTrue(trunk.getSize() > 0);
    }

    @Test
    @DisplayName("Test if grow function of Trunk adds branches.")
    public void trunkAddBranchTest() {
        TestTree tree = new TestTree();

        Trunk<TestBranch, TestLeaf> trunk = new Trunk<>(tree);
        Assertions.assertFalse(trunk.hasBranches());
        trunk.grow();
        Assertions.assertTrue(trunk.hasBranches());
    }
}
