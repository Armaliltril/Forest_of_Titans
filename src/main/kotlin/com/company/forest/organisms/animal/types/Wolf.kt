package com.company.forest.organisms.animal.types

import com.company.forest.organisms.animal.AnimalType
import com.company.forest.organisms.animal.CarnivorousBehavior
import javafx.scene.paint.Color

class Wolf: CarnivorousBehavior() {
    override fun getColor() = Color.DARKGREY!!
    override fun getType() = AnimalType.WOLF
}