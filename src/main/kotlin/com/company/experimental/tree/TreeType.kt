package com.company.experimental.tree

import java.util.*

enum class TreeType {

    BASE_TREE() {
        override fun createData(tree: Tree, xCoord: Int, yCoord: Int): TreeData =
                TreeData.Builder()
                        .setBehavior(tree)
                        .setName(createName(tree))
                        .setMaxFood(100)
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
