package com.company.experimental.animal.example

import com.company.experimental.animal.AnimalType
import com.company.experimental.animal.HerbivorousBehavior
import javafx.scene.paint.Color

class Squirrel: HerbivorousBehavior() {
    override fun getColor() = Color.ORANGE!!
    override fun getType() = AnimalType.SQUIRREL
}