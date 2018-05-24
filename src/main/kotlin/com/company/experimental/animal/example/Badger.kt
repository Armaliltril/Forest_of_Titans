package com.company.experimental.animal.example

import com.company.experimental.animal.AnimalType
import com.company.experimental.animal.HerbivorousBehavior
import javafx.scene.paint.Color

class Badger: HerbivorousBehavior() {
    override fun getColor() = Color.BLACK!!
    override fun getType() = AnimalType.BADGER
}