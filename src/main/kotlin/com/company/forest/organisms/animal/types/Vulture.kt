package com.company.forest.organisms.animal.types

import com.company.forest.organisms.animal.AnimalType
import com.company.forest.organisms.animal.CarnivorousBehavior
import javafx.scene.paint.Color

class Vulture: CarnivorousBehavior() {
    override fun getColor() = Color.RED!!
    override fun getType() = AnimalType.VULTURE
}