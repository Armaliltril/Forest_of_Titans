package com.company.forest.organisms.animal.types

import com.company.forest.organisms.animal.AnimalType
import com.company.forest.organisms.animal.HerbivorousBehavior
import javafx.scene.paint.Color

class Badger: HerbivorousBehavior() {
    override fun getColor() = Color.BLACK!!
    override fun getType() = AnimalType.BADGER
}