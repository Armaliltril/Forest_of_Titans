package com.company.forest.organisms.tree.types

import com.company.forest.organisms.tree.BaseTreeBehavior
import com.company.forest.organisms.tree.TreeType
import javafx.scene.paint.Color

class Oak: BaseTreeBehavior() {
    override fun getColor() = Color.DARKGOLDENROD!!
    override fun getType() = TreeType.OAK
}