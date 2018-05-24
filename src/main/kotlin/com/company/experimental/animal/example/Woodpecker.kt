package com.company.experimental.animal.example

import com.company.experimental.animal.AnimalType
import com.company.experimental.animal.HerbivorousBehavior
import javafx.scene.paint.Color

class Woodpecker: HerbivorousBehavior() {
    override fun getColor() = Color.LIGHTBLUE!!
    override fun getType() = AnimalType.WOODPECKER
}