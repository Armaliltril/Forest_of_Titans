package com.company.forest.organisms.tree.types

import com.company.forest.organisms.tree.BaseTreeBehavior
import com.company.forest.organisms.tree.TreeType
import javafx.scene.paint.Color

class Maple: BaseTreeBehavior() {
    override fun getColor() = Color.CRIMSON!!
    override fun getType() = TreeType.MAPLE
}