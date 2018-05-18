package com.company.experimental.tree

import java.util.*

enum class TreeType {

    TREE() {
        override fun createData(tree: Tree, xCoord: Int, yCoord: Int): TreeData =
                TreeData.Builder()
                        .setName(createName(tree))
                        .setBehavior(tree)
                        .setMaxFood(10)
                        .setFoodFrequency(30)
                        .setFoodPerTime(5)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    };

    protected fun createName(tree: Tree) =
            tree.getType().toString() + ":" + Random().nextInt()
    abstract fun createData(tree: Tree, xCoord: Int = 0, yCoord: Int = 0): TreeData
}
