package com.company.forest.organisms.animal.types

import com.company.forest.organisms.animal.AnimalType
import com.company.forest.organisms.animal.HerbivorousBehavior
import javafx.scene.paint.Color

class FlyingSquirrel: HerbivorousBehavior() {
    override fun getColor() = Color.YELLOW!!
    override fun getType() = AnimalType.FLYING_SQUIRREL
}