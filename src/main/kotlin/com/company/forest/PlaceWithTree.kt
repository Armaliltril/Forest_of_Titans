package com.company.forest

import com.company.forest.organisms.trees.ExampleTree
import com.company.forest.organisms.trees.Tree


@InProgress
class PlaceWithTree: Place() {
    @InProgress val tree = ExampleTree()
    override var color = tree.color
}