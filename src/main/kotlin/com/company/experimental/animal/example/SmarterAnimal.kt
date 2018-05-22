package com.company.experimental.animal.example

import com.company.experimental.animal.AnimalType
import com.company.experimental.animal.BaseAnimalBehavior
import javafx.scene.paint.Color

class SmarterAnimal: BaseAnimalBehavior() {
    override fun tick() {

    }

    override fun getColor() = Color.VIOLET
    override fun getType() = AnimalType.WALKING_MEAT
}