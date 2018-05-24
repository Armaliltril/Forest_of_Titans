package com.company.experimental.animal.example

import com.company.experimental.animal.AnimalType
import com.company.experimental.animal.CarnivorousBehavior
import javafx.scene.paint.Color

class Wolf: CarnivorousBehavior() {
    override fun getColor() = Color.DARKGREY
    override fun getType() = AnimalType.WOLF
}