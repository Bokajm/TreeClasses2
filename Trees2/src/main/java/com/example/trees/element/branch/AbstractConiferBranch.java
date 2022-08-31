package com.example.trees.element.branch;

import com.example.trees.element.leaf.AbstractLeaf;
import com.example.trees.element.trunk.Trunk;
import com.example.trees.tree.AbstractConifer;

public abstract class AbstractConiferBranch<B extends AbstractConiferBranch<B, L>, L extends AbstractLeaf> extends AbstractBranch<B, L> {
    public AbstractConiferBranch(AbstractConifer<? extends Trunk<B, L>, B, L> tree) {
        super(tree);
    }

    @Override
    public void grow() {
        super.grow();

        produceNewLeaves();
    }
}
