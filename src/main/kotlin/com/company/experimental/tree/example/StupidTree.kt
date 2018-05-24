package com.company.experimental.tree.example

import com.company.experimental.tree.BaseTreeBehavior
import com.company.experimental.tree.TreeType
import javafx.scene.paint.Color

class StupidTree: BaseTreeBehavior() {
    override fun tick() {
        produceFood()
    }

    override fun getColor(): Color {
        return Color.YELLOW
    }

    override fun getType(): TreeType {
        return TreeType.BASE_TREE
    }
}