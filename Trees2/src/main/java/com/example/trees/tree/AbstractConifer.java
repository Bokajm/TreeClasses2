package com.example.trees.tree;

import com.example.trees.element.trunk.Trunk;
import com.example.trees.element.branch.AbstractConiferBranch;
import com.example.trees.element.leaf.AbstractLeaf;

public abstract class AbstractConifer<T extends Trunk<B, L>, B extends AbstractConiferBranch<B, L>, L extends AbstractLeaf> extends AbstractTree<T, B, L> {
    public AbstractConifer(String species) {
        super(species);
    }
}
