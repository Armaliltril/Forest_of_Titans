package com.company.experimental.tree.example

import com.company.experimental.tree.BaseTreeBehavior
import com.company.experimental.tree.TreeType
import javafx.scene.paint.Color

class Spruce: BaseTreeBehavior() {
    override fun getColor() = Color.DARKGREEN!!
    override fun getType() = TreeType.SPRUCE
}