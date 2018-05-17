package com.company.experimental.animal

import javafx.scene.paint.Color
import com.company.forest.Place

interface Animal: AnimalBehavior {
    fun associateWith(herald: AnimalData.AnimalHerald)

    fun tick()

    fun getType() : AnimalType

    fun getColor() : Color

    fun createData(x: Int, y: Int) = getType().createData(this, x, y)
}

interface AnimalBehavior{
    fun goAhead()

    fun rotateRightHand(right: Boolean)

    fun eat(place: Place)

    fun fight(place: Place)

    fun regenerate()

    fun reproduce(place: Place)

    fun askExtraTurn()
}