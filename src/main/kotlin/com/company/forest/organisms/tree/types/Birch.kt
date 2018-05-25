package com.company.forest.organisms.tree.types

import com.company.forest.organisms.tree.BaseTreeBehavior
import com.company.forest.organisms.tree.TreeType
import javafx.scene.paint.Color

class Birch: BaseTreeBehavior() {
    override fun getColor() = Color.LIGHTGRAY!!
    override fun getType() = TreeType.BIRCH
}