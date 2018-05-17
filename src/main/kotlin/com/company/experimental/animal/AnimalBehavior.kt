package com.company.experimental.animal

import com.company.experimental.Rotations
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
    fun goAhead() : Boolean

    fun turnAround(rotation: Rotations): Boolean

    fun eat(place: Place) : Boolean

    fun fight(place: Place) : Boolean

    fun regenerate() : Boolean

    fun reproduce(place: Place) : Boolean

    fun askExtraTurn() : Boolean

    fun seeEnemies(): List<Place>

    fun seeFood(): List<Place>

    fun seeFriends(): List<Place>
}