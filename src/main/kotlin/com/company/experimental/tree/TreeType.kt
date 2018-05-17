package com.company.experimental.tree

enum class TreeType {

    TREE() {
        override fun createData(tree: Tree, xCoord: Int, yCoord: Int): TreeData =
                TreeData.Builder()
                        .setBehavior(tree)
                        .setMaxFood(10)
                        .setFoodFrequency(30)
                        .setFoodPerTime(5)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    };

    abstract fun createData(tree: Tree, xCoord: Int = 0, yCoord: Int = 0): TreeData
}
