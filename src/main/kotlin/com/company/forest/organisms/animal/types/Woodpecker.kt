package com.company.forest.organisms.animal.types

import com.company.forest.organisms.animal.AnimalType
import com.company.forest.organisms.animal.HerbivorousBehavior
import javafx.scene.paint.Color

class Woodpecker: HerbivorousBehavior() {
    override fun getColor() = Color.LIGHTBLUE!!
    override fun getType() = AnimalType.WOODPECKER
}