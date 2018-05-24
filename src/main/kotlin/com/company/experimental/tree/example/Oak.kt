package com.company.experimental.tree.example

import com.company.experimental.tree.BaseTreeBehavior
import com.company.experimental.tree.TreeType
import javafx.scene.paint.Color

class Oak: BaseTreeBehavior() {
    override fun getColor() = Color.DARKGOLDENROD!!
    override fun getType() = TreeType.OAK
}