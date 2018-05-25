package com.company.forest.organisms.animal.types

import com.company.forest.organisms.animal.AnimalType
import com.company.forest.organisms.animal.HerbivorousBehavior
import javafx.scene.paint.Color

class Squirrel: HerbivorousBehavior() {
    override fun getColor() = Color.ORANGE!!
    override fun getType() = AnimalType.SQUIRREL
}