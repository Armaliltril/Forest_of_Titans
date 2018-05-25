package com.company.forest.organisms.animal.types

import com.company.forest.organisms.animal.AnimalType
import com.company.forest.organisms.animal.CarnivorousBehavior
import javafx.scene.paint.Color

class SmarterAnimal: CarnivorousBehavior() {

    override fun getColor() = Color.VIOLET!!
    override fun getType() = AnimalType.WALKING_MEAT
}