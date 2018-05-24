package com.company.experimental.animal.example

import com.company.experimental.Rotations
import com.company.experimental.animal.AnimalType
import com.company.experimental.animal.BaseAnimalBehavior
import com.company.experimental.tree.BaseTreeBehavior
import com.company.experimental.tree.TreeType

import javafx.scene.paint.Color

class StupidAnimal: BaseAnimalBehavior() {
    override fun tick() {
        if (!goAhead()){
            turnAround(Rotations.LEFT)
            goAhead()
        }
    }

    override fun getColor() = Color.RED!!

    override fun getType() = AnimalType.WALKING_MEAT
}