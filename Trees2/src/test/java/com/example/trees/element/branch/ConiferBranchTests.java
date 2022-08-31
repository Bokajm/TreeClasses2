package com.example.trees.element.branch;

import com.example.trees.element.trunk.Trunk;
import com.example.trees.element.leaf.AbstractLeaf;
import com.example.trees.tree.AbstractConifer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConiferBranchTests {
    private static class TestLeaf extends AbstractLeaf {
        public TestLeaf() {
            super("Test leaf");
        }
    }

    private static class TestTrunk extends Trunk<ConiferBranch<TestLeaf>, TestLeaf> {
        public TestTrunk(TestTree tree) {
            super(tree);
        }
    }

    private static class TestTree extends AbstractConifer<Trunk<ConiferBranch<TestLeaf>, TestLeaf>, ConiferBranch<TestLeaf>, TestLeaf> {

        public TestTree() {
            super("Test tree");
        }

        @Override
        public TestLeaf newLeaf() {
            return new TestLeaf();
        }

        @Override
        public ConiferBranch<TestLeaf> newBranch() {
            return new ConiferBranch<>(this);
        }

        @Override
        public TestTrunk newTrunk() {
            return new TestTrunk(this);
        }
    }

    @Test
    @DisplayName("Test if ConiferBranch is created with proper size.")
    public void coniferBranchCreateTest() {
        TestTree tree = new TestTree();

        ConiferBranch<TestLeaf> branch = new ConiferBranch<>(tree);
        Assertions.assertEquals(branch.getSize(), 0);
    }

    @Test
    @DisplayName("Test if grow function of ConiferBranch changes size.")
    public void coniferBranchGrowTest() {
        TestTree tree = new TestTree();

        ConiferBranch<TestLeaf> branch = new ConiferBranch<>(tree);
        Assertions.assertEquals(branch.getSize(), 0);
        branch.grow();
        Assertions.assertTrue(branch.getSize() > 0);
    }

    @Test
    @DisplayName("Test if grow function of ConiferBranch adds branches.")
    public void coniferBranchAddBranchTest() {
        TestTree tree = new TestTree();

        ConiferBranch<TestLeaf> branch = new ConiferBranch<>(tree);
        Assertions.assertFalse(branch.hasBranches());
        branch.grow();
        Assertions.assertTrue(branch.hasBranches());
    }

    @Test
    @DisplayName("Test if grow function of ConiferBranch adds leaves.")
    public void coniferBranchAddLeafTest() {
        TestTree tree = new TestTree();

        ConiferBranch<TestLeaf> branch = new ConiferBranch<>(tree);
        Assertions.assertFalse(branch.hasLeaves());
        branch.grow();
        Assertions.assertTrue(branch.hasLeaves());
    }
}
