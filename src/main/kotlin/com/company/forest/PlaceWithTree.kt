package com.company.forest

import com.company.experimental.tree.Tree
import com.company.experimental.tree.TreeData

@InProgress
class PlaceWithTree(var tree: TreeData): Place() {
    override var color = tree.behavior.getColor()
}