package com.example.trees.element.trunk;

import com.example.trees.element.branch.AbstractLeafyBranch;
import com.example.trees.element.leaf.AbstractLeaf;
import com.example.trees.tree.AbstractTree;

public class LeafyTrunk<B extends AbstractLeafyBranch<B, L>, L extends AbstractLeaf> extends Trunk<B, L> {
    public LeafyTrunk(AbstractTree<? extends LeafyTrunk<B, L>, B, L> tree) {
        super(tree);
    }

    public void dropLeaves() {
        branches.forEach(AbstractLeafyBranch::dropLeaves);
    }

    public void growLeaves() {
        branches.forEach(AbstractLeafyBranch::growLeaves);
    }
}
