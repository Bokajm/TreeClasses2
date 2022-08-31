package com.example.trees.tree;

import com.example.trees.element.branch.ConiferBranch;
import com.example.trees.element.trunk.Trunk;
import com.example.trees.element.leaf.SpruceNeedle;

public class Spruce extends AbstractConifer<Trunk<ConiferBranch<SpruceNeedle>, SpruceNeedle>, ConiferBranch<SpruceNeedle>, SpruceNeedle> {
    public Spruce() {
        super("Spruce");
    }

    @Override
    public SpruceNeedle newLeaf() {
        return new SpruceNeedle();
    }

    @Override
    public ConiferBranch<SpruceNeedle> newBranch() {
        return new ConiferBranch<>(this);
    }

    @Override
    public Trunk<ConiferBranch<SpruceNeedle>, SpruceNeedle> newTrunk() {
        return new Trunk<>(this);
    }
}
