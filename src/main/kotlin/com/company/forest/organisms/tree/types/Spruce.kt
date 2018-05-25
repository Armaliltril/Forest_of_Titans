package com.company.forest.organisms.tree.types

import com.company.forest.organisms.tree.BaseTreeBehavior
import com.company.forest.organisms.tree.TreeType
import javafx.scene.paint.Color

class Spruce: BaseTreeBehavior() {
    override fun getColor() = Color.DARKGREEN!!
    override fun getType() = TreeType.SPRUCE
}