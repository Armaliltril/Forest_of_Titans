package com.company.forest

import com.company.forest.organisms.trees.ExampleTree
import com.company.forest.organisms.trees.Tree


@InProgress
class PlaceWithTree(var tree: Tree): Place() {
    override var color = tree.color
}