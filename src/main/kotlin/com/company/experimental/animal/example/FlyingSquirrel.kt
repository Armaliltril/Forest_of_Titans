package com.company.experimental.animal.example

import com.company.experimental.animal.AnimalType
import com.company.experimental.animal.HerbivorousBehavior
import javafx.scene.paint.Color

class FlyingSquirrel: HerbivorousBehavior() {
    override fun getColor() = Color.YELLOW
    override fun getType() = AnimalType.FLYING_SQUIRREL
}