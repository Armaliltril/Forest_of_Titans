package com.company.forest.organisms.tree

import java.util.*

enum class TreeType {

    BASE_TREE() {
        override fun createData(tree: Tree, xCoord: Int, yCoord: Int): TreeData =
                TreeData.Builder()
                        .setBehavior(tree)
                        .setName(createName(tree))
                        .setMaxFoodAndFood(100, 50, 80)
                        .setFoodFrequency(30)
                        .setFoodPerTime(5)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    BIRCH() {
        override fun createData(tree: Tree, xCoord: Int, yCoord: Int): TreeData =
                TreeData.Builder()
                        .setBehavior(tree)
                        .setName(createName(tree))
                        .setMaxFoodAndFood(80, 60, 10)
                        .setFoodFrequency(20)
                        .setFoodPerTime(5)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    HAZEL() {
        override fun createData(tree: Tree, xCoord: Int, yCoord: Int): TreeData =
                TreeData.Builder()
                        .setBehavior(tree)
                        .setName(createName(tree))
                        .setMaxFoodAndFood(10, 30, 100)
                        .setFoodFrequency(50)
                        .setFoodPerTime(10)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    MAPLE() {
        override fun createData(tree: Tree, xCoord: Int, yCoord: Int): TreeData =
                TreeData.Builder()
                        .setBehavior(tree)
                        .setName(createName(tree))
                        .setMaxFoodAndFood(100, 40, 10)
                        .setFoodFrequency(30)
                        .setFoodPerTime(10)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    OAK() {
        override fun createData(tree: Tree, xCoord: Int, yCoord: Int): TreeData =
                TreeData.Builder()
                        .setBehavior(tree)
                        .setName(createName(tree))
                        .setMaxFoodAndFood(10, 50, 120)
                        .setFoodFrequency(50)
                        .setFoodPerTime(25)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    PINE() {
        override fun createData(tree: Tree, xCoord: Int, yCoord: Int): TreeData =
                TreeData.Builder()
                        .setBehavior(tree)
                        .setName(createName(tree))
                        .setMaxFoodAndFood(10, 20, 100)
                        .setFoodFrequency(20)
                        .setFoodPerTime(5)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    },

    SPRUCE() {
        override fun createData(tree: Tree, xCoord: Int, yCoord: Int): TreeData =
                TreeData.Builder()
                        .setBehavior(tree)
                        .setName(createName(tree))
                        .setMaxFoodAndFood(10, 30, 80)
                        .setFoodFrequency(30)
                        .setFoodPerTime(15)
                        .setXPosition(xCoord)
                        .setYPosition(yCoord)
                        .build()
    };

    protected fun createName(tree: Tree) =
            tree.getType().toString() + ":" + Random().nextInt()
    abstract fun createData(tree: Tree, xCoord: Int = 0, yCoord: Int = 0): TreeData
}
