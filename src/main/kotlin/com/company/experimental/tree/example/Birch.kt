package com.company.experimental.tree.example

import com.company.experimental.tree.BaseTreeBehavior
import com.company.experimental.tree.TreeType
import javafx.scene.paint.Color

class Birch: BaseTreeBehavior() {
    override fun getColor() = Color.LIGHTGRAY!!
    override fun getType() = TreeType.BIRCH
}