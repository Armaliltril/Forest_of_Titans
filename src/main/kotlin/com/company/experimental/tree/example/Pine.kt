package com.company.experimental.tree.example

import com.company.experimental.tree.BaseTreeBehavior
import com.company.experimental.tree.TreeType
import javafx.scene.paint.Color

class Pine: BaseTreeBehavior() {
    override fun getColor() = Color.LIGHTGREEN
    override fun getType() = TreeType.PINE
}