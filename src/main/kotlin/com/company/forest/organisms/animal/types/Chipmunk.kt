package com.company.forest.organisms.animal.types

import com.company.forest.organisms.animal.AnimalType
import com.company.forest.organisms.animal.HerbivorousBehavior
import javafx.scene.paint.Color

class Chipmunk: HerbivorousBehavior() {
    override fun getColor() = Color.CRIMSON!!
    override fun getType() = AnimalType.CHIPMUNK
}