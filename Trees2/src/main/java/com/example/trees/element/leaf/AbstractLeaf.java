package com.example.trees.element.leaf;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public abstract class AbstractLeaf {
    private final String leafSpecies;
    private double size;

    public AbstractLeaf(String species) {
        this.leafSpecies = species;
        this.size = 0;
    }

    public void grow() {
        size++;
        log.info("{} {} grows in size.", this.leafSpecies, System.identityHashCode(this));
    }
}
