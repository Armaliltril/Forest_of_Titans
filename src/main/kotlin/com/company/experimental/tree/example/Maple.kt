package com.company.experimental.tree.example

import com.company.experimental.tree.BaseTreeBehavior
import com.company.experimental.tree.TreeType
import javafx.scene.paint.Color

class Maple: BaseTreeBehavior() {
    override fun getColor() = Color.CRIMSON!!
    override fun getType() = TreeType.MAPLE
}