package com.company.experimental.animal.example

import com.company.experimental.animal.AnimalType
import com.company.experimental.animal.BaseAnimalBehavior
import com.company.experimental.animal.CarnivorousBehavior
import javafx.scene.paint.Color

class SmarterAnimal: CarnivorousBehavior() {

    override fun getColor() = Color.VIOLET
    override fun getType() = AnimalType.WALKING_MEAT
}