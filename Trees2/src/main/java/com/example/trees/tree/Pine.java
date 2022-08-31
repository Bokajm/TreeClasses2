package com.example.trees.tree;

import com.example.trees.element.branch.ConiferBranch;
import com.example.trees.element.trunk.Trunk;
import com.example.trees.element.leaf.PineNeedle;

public class Pine extends AbstractConifer<Trunk<ConiferBranch<PineNeedle>, PineNeedle>, ConiferBranch<PineNeedle>, PineNeedle> {
    public Pine() {
        super("Pine");
    }

    @Override
    public PineNeedle newLeaf() {
        return new PineNeedle();
    }

    @Override
    public ConiferBranch<PineNeedle> newBranch() {
        return new ConiferBranch<>(this);
    }

    @Override
    public Trunk<ConiferBranch<PineNeedle>, PineNeedle> newTrunk() {
        return new Trunk<>(this);
    }
}
