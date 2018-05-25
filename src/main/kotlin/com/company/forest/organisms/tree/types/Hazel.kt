package com.company.forest.organisms.tree.types

import com.company.forest.organisms.tree.BaseTreeBehavior
import com.company.forest.organisms.tree.TreeType
import javafx.scene.paint.Color

class Hazel: BaseTreeBehavior() {
    override fun getColor() = Color.BROWN!!
    override fun getType() = TreeType.HAZEL
}