package com.company.experimental.animal.example

import com.company.experimental.animal.AnimalType
import com.company.experimental.animal.BaseAnimalBehavior
import com.company.experimental.tree.BaseTreeBehavior
import com.company.experimental.tree.TreeType

import javafx.scene.paint.Color

class StupidAnimal: BaseAnimalBehavior() {
    override fun tick() {
    }

    override fun getColor(): Color {
        return Color.RED
    }

    override fun getType(): AnimalType {
        return AnimalType.WALKING_MEAT
    }
}