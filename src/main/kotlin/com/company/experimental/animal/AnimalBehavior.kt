package com.company.experimental.animal

import com.company.experimental.Rotations
import javafx.scene.paint.Color
import com.company.forest.Place



interface AnimalBehavior{
    fun goAhead() : Boolean

    fun turnAround(rotation: Rotations): Boolean

    fun eat() : Boolean

    fun fight(animal: AnimalData) : Boolean

    fun regenerate() : Boolean

    fun reproduce(place: Place) : Boolean

    fun askExtraTurn() : Boolean

    fun seeFront()
}