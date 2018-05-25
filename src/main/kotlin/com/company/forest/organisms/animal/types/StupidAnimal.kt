package com.company.forest.organisms.animal.types

import com.company.forest.organisms.Rotations
import com.company.forest.organisms.animal.AnimalType
import com.company.forest.organisms.animal.BaseAnimalBehavior

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