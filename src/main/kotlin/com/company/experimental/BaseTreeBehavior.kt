package com.company.experimental

abstract class BaseTreeBehavior : Tree{
    lateinit var herald: TreeData.TreeHerald

    override fun associateWith(herald: TreeData.TreeHerald) {
        this.herald = herald
    }
}