package com.example.trees.element.branch;

import com.example.trees.element.leaf.AbstractLeaf;
import com.example.trees.element.trunk.LeafyTrunk;
import com.example.trees.tree.AbstractLeafyTree;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractLeafyBranch<B extends AbstractLeafyBranch<B, L>, L extends AbstractLeaf> extends AbstractBranch<B, L> {
    public AbstractLeafyBranch(AbstractLeafyTree<? extends LeafyTrunk<B, L>, B, L> tree) {
        super(tree);
    }

    public void dropLeaves() {
        leaves.clear();
        branches.forEach(AbstractLeafyBranch::dropLeaves);
        log.info("{} {} drops its leaves", this.getClass().getSimpleName(), System.identityHashCode(this));
    }

    public void growLeaves() {
        //Grow some amount of leaves
        for (int i = 0; i < 10; i++) {
            produceNewLeaves();
        }
        branches.forEach(AbstractLeafyBranch::growLeaves);
    }

}
