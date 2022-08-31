package com.example.trees.element.branch;

import com.example.trees.element.leaf.AbstractLeaf;
import com.example.trees.element.trunk.Trunk;
import com.example.trees.tree.AbstractConifer;

public class ConiferBranch<L extends AbstractLeaf> extends AbstractConiferBranch<ConiferBranch<L>, L> {
    public ConiferBranch(AbstractConifer<? extends Trunk<ConiferBranch<L>, L>, ConiferBranch<L>, L> tree) {
        super(tree);
    }
}
