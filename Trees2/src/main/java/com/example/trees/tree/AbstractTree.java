package com.example.trees.tree;

import com.example.trees.element.branch.AbstractBranch;
import com.example.trees.element.leaf.AbstractLeaf;
import com.example.trees.element.trunk.Trunk;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Getter
public abstract class AbstractTree<T extends Trunk<B, L>, B extends AbstractBranch<B, L>, L extends AbstractLeaf> {
    private final String species;
    protected int age;
    private T trunk;

    public AbstractTree(String species) {
        this.species = species;
        this.age = 0;
    }

    public void init() {
        trunk = newTrunk();

        if (Objects.isNull(trunk)) {
            log.warn("Could not create trunk in {} {}", this.getClass().getSimpleName(), System.identityHashCode(this));
        } else {
            log.info("{} {} created with {} {}", this.getClass().getSimpleName(), System.identityHashCode(this), trunk.getClass().getSimpleName(), System.identityHashCode(trunk));
        }

    }

    public void grow() {
        if (Objects.isNull(trunk)) {
            init();
        }

        age++;
        trunk.grow();
    }

    public boolean hasBranches() {
        return trunk.hasBranches();
    }

    public boolean hasLeaves() {
        return trunk.hasLeaves();
    }

    public abstract L newLeaf();

    public abstract B newBranch();

    public abstract T newTrunk();
}
