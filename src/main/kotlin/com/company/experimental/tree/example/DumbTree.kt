package com.company.experimental.tree.example

import com.company.experimental.tree.BaseTreeBehavior
import com.company.experimental.tree.TreeType
import javafx.scene.paint.Color

class DumbTree: BaseTreeBehavior() {
    override fun tick() {
        produceFood()
    }

    override fun getColor() = Color.BROWN
    override fun getType() = TreeType.BASE_TREE
}