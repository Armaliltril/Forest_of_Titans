package com.company.forest.organisms.tree

import javafx.scene.paint.Color

interface Tree: TreeBehavior {
    fun associateWith(herald: TreeData.TreeHerald)

    fun tick()

    fun getColor() : Color

    fun getType() : TreeType

    fun createData(x: Int, y: Int) = getType().createData(this, x, y)
}