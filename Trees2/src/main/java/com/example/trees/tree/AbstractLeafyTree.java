package com.example.trees.tree;

import com.example.trees.element.trunk.LeafyTrunk;
import com.example.trees.element.branch.AbstractLeafyBranch;
import com.example.trees.element.leaf.AbstractLeaf;

public abstract class AbstractLeafyTree<T extends LeafyTrunk<B, L>, B extends AbstractLeafyBranch<B, L>, L extends AbstractLeaf> extends AbstractTree<T, B, L> {
    public AbstractLeafyTree(String species) {
        super(species);
    }

    @Override
    public void grow() {
        super.grow();
        if (age % 4 == 0) {
            growLeaves();
        } else if (age % 4 == 3) {
            dropLeaves();
        }
    }

    public void dropLeaves() {
        getTrunk().dropLeaves();
    }

    public void growLeaves() {
        getTrunk().growLeaves();
    }
}
