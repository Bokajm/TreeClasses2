package com.example.trees.element.branch;

import com.example.trees.element.trunk.LeafyTrunk;
import com.example.trees.element.leaf.AbstractLeaf;
import com.example.trees.tree.AbstractLeafyTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LeafyBranchTests {
    private static class TestLeaf extends AbstractLeaf {
        public TestLeaf() {
            super("Test leaf");
        }
    }

    private static class TestTrunk extends LeafyTrunk<LeafyBranch<TestLeaf>, TestLeaf> {
        public TestTrunk(TestTree tree) {
            super(tree);
        }
    }

    private static class TestTree extends AbstractLeafyTree<TestTrunk, LeafyBranch<TestLeaf>, TestLeaf> {

        public TestTree() {
            super("Test tree");
        }

        @Override
        public TestLeaf newLeaf() {
            return new TestLeaf();
        }

        @Override
        public LeafyBranch<TestLeaf> newBranch() {
            return new LeafyBranch<>(this);
        }

        @Override
        public TestTrunk newTrunk() {
            return new TestTrunk(this);
        }
    }

    @Test
    @DisplayName("Test if LeafyBranch is created with proper size.")
    public void leafyBranchCreateTest() {
        TestTree tree = new TestTree();

        LeafyBranch<TestLeaf> branch = new LeafyBranch<>(tree);
        Assertions.assertEquals(branch.getSize(), 0);
    }

    @Test
    @DisplayName("Test if grow function of LeafyBranch changes size.")
    public void leafyBranchGrowTest() {
        TestTree tree = new TestTree();

        LeafyBranch<TestLeaf> branch = new LeafyBranch<>(tree);
        Assertions.assertEquals(branch.getSize(), 0);
        branch.grow();
        Assertions.assertTrue(branch.getSize() > 0);
    }

    @Test
    @DisplayName("Test if grow function of LeafyBranch adds branches.")
    public void leafyBranchAddBranchTest() {
        TestTree tree = new TestTree();

        LeafyBranch<TestLeaf> branch = new LeafyBranch<>(tree);
        Assertions.assertFalse(branch.hasBranches());
        branch.grow();
        Assertions.assertTrue(branch.hasBranches());
    }

    @Test
    @DisplayName("Test if growLeaves function of LeafyBranch adds leaves.")
    public void leafyBranchAddLeafTest() {
        TestTree tree = new TestTree();

        LeafyBranch<TestLeaf> branch = new LeafyBranch<>(tree);
        Assertions.assertFalse(branch.hasLeaves());
        branch.growLeaves();
        Assertions.assertTrue(branch.hasLeaves());
    }

    @Test
    @DisplayName("Test if growLeaves function of LeafyBranch adds leaves.")
    public void leafyBranchDropLeafTest() {
        TestTree tree = new TestTree();

        LeafyBranch<TestLeaf> branch = new LeafyBranch<>(tree);
        Assertions.assertFalse(branch.hasLeaves());
        branch.growLeaves();
        Assertions.assertTrue(branch.hasLeaves());
        branch.dropLeaves();
        Assertions.assertFalse(branch.hasLeaves());
    }
}
