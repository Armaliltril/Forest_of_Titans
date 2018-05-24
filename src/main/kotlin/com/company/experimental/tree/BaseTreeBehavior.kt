package com.company.experimental.tree

abstract class BaseTreeBehavior : Tree {
    private lateinit var herald: TreeData.TreeHerald

    override fun associateWith(herald: TreeData.TreeHerald) {
        this.herald = herald
    }

    override fun produceFood() {
        herald.produceFood()
    }

    override fun tick() {
        produceFood()
    }
}