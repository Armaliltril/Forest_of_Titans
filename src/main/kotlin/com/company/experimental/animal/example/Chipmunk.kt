package com.company.experimental.animal.example

import com.company.experimental.animal.AnimalType
import com.company.experimental.animal.HerbivorousBehavior
import javafx.scene.paint.Color

class Chipmunk: HerbivorousBehavior() {
    override fun getColor() = Color.CRIMSON
    override fun getType() = AnimalType.CHIPMUNK
}