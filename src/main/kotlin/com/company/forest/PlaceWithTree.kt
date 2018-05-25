package com.company.forest

import com.company.forest.organisms.tree.TreeData

@InProgress
class PlaceWithTree(var tree: TreeData): Place() {
    override var color = tree.behavior.getColor()
}