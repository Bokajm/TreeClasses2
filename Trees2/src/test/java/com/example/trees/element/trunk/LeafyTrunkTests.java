package com.example.trees.element.trunk;

import com.example.trees.element.branch.AbstractLeafyBranch;
import com.example.trees.element.leaf.AbstractLeaf;
import com.example.trees.tree.AbstractLeafyTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LeafyTrunkTests {
    private static class TestLeaf extends AbstractLeaf {
        public TestLeaf() {
            super("Test leaf");
        }
    }

    private static class TestBranch extends AbstractLeafyBranch<TestBranch, TestLeaf> {
        public TestBranch(TestTree tree) {
            super(tree);
        }
    }

    private static class TestTree extends AbstractLeafyTree<LeafyTrunk<TestBranch, TestLeaf>, TestBranch, TestLeaf> {

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
        public LeafyTrunk<TestBranch, TestLeaf> newTrunk() {
            return new LeafyTrunk<>(this);
        }
    }

    @Test
    @DisplayName("Test if LeafyTrunk is created with proper size.")
    public void leafyTrunkCreateTest() {
        TestTree tree = new TestTree();

        LeafyTrunk<TestBranch, TestLeaf> trunk = new LeafyTrunk<>(tree);
        Assertions.assertEquals(trunk.getSize(), 0);
    }

    @Test
    @DisplayName("Test if grow function of LeafyTrunk changes size.")
    public void leafyTrunkGrowTest() {
        TestTree tree = new TestTree();

        LeafyTrunk<TestBranch, TestLeaf> trunk = new LeafyTrunk<>(tree);
        Assertions.assertEquals(trunk.getSize(), 0);
        trunk.grow();
        Assertions.assertTrue(trunk.getSize() > 0);
    }

    @Test
    @DisplayName("Test if grow function of LeafyTrunk adds branches.")
    public void leafyTrunkAddBranchTest() {
        TestTree tree = new TestTree();

        LeafyTrunk<TestBranch, TestLeaf> trunk = new LeafyTrunk<>(tree);
        Assertions.assertFalse(trunk.hasBranches());
        trunk.grow();
        Assertions.assertTrue(trunk.hasBranches());
    }
}
