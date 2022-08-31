package com.example.trees.element;

import com.example.trees.element.branch.AbstractBranch;
import com.example.trees.element.leaf.AbstractLeaf;
import com.example.trees.element.trunk.Trunk;
import com.example.trees.tree.AbstractTree;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Getter
public abstract class AbstractWoodElement<B extends AbstractBranch<B, L>, L extends AbstractLeaf> {
    protected AbstractTree<? extends Trunk<B, L>, B, L> tree;

    protected double size;
    protected final List<B> branches;

    protected AbstractWoodElement(AbstractTree<? extends Trunk<B, L>, B, L> tree) {
        this.tree = tree;
        this.size = 0;
        this.branches = new ArrayList<>();
    }

    public void grow() {
        increaseSize();
        branches.forEach(AbstractBranch::grow);
        produceNewBranches();
    }

    protected void increaseSize() {
        size++;
        log.info("{} {} grows in size.", this.getClass().getSimpleName(), System.identityHashCode(this));
    }

    protected void produceNewBranches() {
        B newBranch = tree.newBranch();
        if (Objects.isNull(newBranch)) {
            log.warn("Could not create branch in {} {}", this.getClass().getSimpleName(), System.identityHashCode(this));
        } else {
            branches.add(newBranch);
            log.info("{} {} adds a new {} {}", this.getClass().getSimpleName(), System.identityHashCode(this), newBranch.getClass().getSimpleName(), System.identityHashCode(newBranch));
        }
    }

    public boolean hasBranches() {
        return !branches.isEmpty();
    }

    public abstract boolean hasLeaves();
}
