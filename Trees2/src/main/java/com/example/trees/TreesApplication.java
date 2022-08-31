package com.example.trees;

import com.example.trees.tree.Oak;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TreesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TreesApplication.class, args);
        Oak a = new Oak();

        a.grow();
        a.grow();
        a.grow();
        a.grow();
        a.grow();
    }
}
