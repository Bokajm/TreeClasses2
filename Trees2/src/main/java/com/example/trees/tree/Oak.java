package com.example.trees.tree;

import com.example.trees.element.branch.LeafyBranch;
import com.example.trees.element.trunk.LeafyTrunk;
import com.example.trees.element.leaf.OakLeaf;

public class Oak extends AbstractLeafyTree<LeafyTrunk<LeafyBranch<OakLeaf>, OakLeaf>, LeafyBranch<OakLeaf>, OakLeaf> {
    public Oak() {
        super("Oak");
    }

    @Override
    public OakLeaf newLeaf() {
        return new OakLeaf();
    }

    @Override
    public LeafyBranch<OakLeaf> newBranch() {
        return new LeafyBranch<>(this);
    }

    @Override
    public LeafyTrunk<LeafyBranch<OakLeaf>, OakLeaf> newTrunk() {
        return new LeafyTrunk<>(this);
    }
}
