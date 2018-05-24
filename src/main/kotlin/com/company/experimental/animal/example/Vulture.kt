package com.company.experimental.animal.example

import com.company.experimental.animal.AnimalType
import com.company.experimental.animal.CarnivorousBehavior
import javafx.scene.paint.Color

class Vulture: CarnivorousBehavior() {
    override fun getColor() = Color.RED!!
    override fun getType() = AnimalType.VULTURE
}