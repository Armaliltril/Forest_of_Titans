package com.company.experimental.tree.example

import com.company.experimental.tree.BaseTreeBehavior
import com.company.experimental.tree.TreeType
import javafx.scene.paint.Color

class Hazel: BaseTreeBehavior() {
    override fun getColor() = Color.BROWN!!
    override fun getType() = TreeType.HAZEL
}