package com.example.trees.element.branch;

import com.example.trees.element.AbstractWoodElement;
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
public abstract class AbstractBranch<B extends AbstractBranch<B, L>, L extends AbstractLeaf> extends AbstractWoodElement<B, L> {
    protected final List<L> leaves;

    public AbstractBranch(AbstractTree<? extends Trunk<B, L>, B, L> tree) {
        super(tree);
        this.leaves = new ArrayList<>();
    }

    public void grow() {
        super.grow();
        leaves.forEach(AbstractLeaf::grow);
    }

    protected void produceNewLeaves() {
        L newLeaf = tree.newLeaf();
        if (Objects.isNull(newLeaf)) {
            log.warn("Could not create leaf in {} {}", this.getClass().getSimpleName(), System.identityHashCode(this));
        } else {
            leaves.add(newLeaf);
            log.info("{} {} adds a new {} {}", this.getClass().getSimpleName(), System.identityHashCode(this), newLeaf.getClass().getSimpleName(), System.identityHashCode(newLeaf));
        }

    }

    public boolean hasLeaves() {
        return !leaves.isEmpty() || branchesHaveLeaves();
    }
}
