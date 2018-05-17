package com.company.experimental

import com.company.forest.Place

interface Tree: TreeBehavior{
    fun associateWith(herald: TreeData.TreeHerald)

    fun tick()

    fun getType() : TreeType
    fun createData() = getType().createData(this)
}

interface TreeBehavior{
    fun produce()
}