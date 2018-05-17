package com.company.experimental.tree

abstract class BaseTreeBehavior : Tree {
    lateinit var herald: TreeData.TreeHerald

    override fun associateWith(herald: TreeData.TreeHerald) {
        this.herald = herald
    }

    override fun produce() {
        herald.produce()
    }
}