package com.company.forest.organisms.tree.types

import com.company.forest.organisms.tree.BaseTreeBehavior
import com.company.forest.organisms.tree.TreeType
import javafx.scene.paint.Color

class Pine: BaseTreeBehavior() {
    override fun getColor() = Color.LIGHTGREEN!!
    override fun getType() = TreeType.PINE
}