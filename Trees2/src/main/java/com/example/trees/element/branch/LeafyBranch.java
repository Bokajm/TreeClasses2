package com.example.trees.element.branch;

import com.example.trees.element.leaf.AbstractLeaf;
import com.example.trees.element.trunk.LeafyTrunk;
import com.example.trees.tree.AbstractLeafyTree;

public class LeafyBranch<L extends AbstractLeaf> extends AbstractLeafyBranch<LeafyBranch<L>, L> {
    public LeafyBranch(AbstractLeafyTree<? extends LeafyTrunk<LeafyBranch<L>, L>, LeafyBranch<L>, L> tree) {
        super(tree);
    }
}
