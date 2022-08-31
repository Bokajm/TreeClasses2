package com.example.trees.element.trunk;

import com.example.trees.element.AbstractWoodElement;
import com.example.trees.element.branch.AbstractBranch;
import com.example.trees.element.leaf.AbstractLeaf;
import com.example.trees.tree.AbstractTree;
import lombok.Getter;

@Getter
public class Trunk<B extends AbstractBranch<B, L>, L extends AbstractLeaf> extends AbstractWoodElement<B, L> {
    public Trunk(AbstractTree<? extends Trunk<B, L>, B, L> tree) {
        super(tree);
    }

    @Override
    public boolean hasLeaves() {
        return branchesHaveLeaves();
    }
}
