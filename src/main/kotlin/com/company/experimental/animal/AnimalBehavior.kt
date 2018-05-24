package com.company.experimental.animal

import com.company.experimental.Rotations
import javafx.scene.paint.Color
import com.company.forest.Place



interface AnimalBehavior{
    fun goAhead() : Boolean

    fun turnAround(rotation: Rotations): Boolean

    fun eat() : Boolean

    fun fight(otherAnimal: AnimalData) : Boolean

    fun regenerate() : Boolean

    fun reproduce(otherAnimal: AnimalData) : Boolean

    fun askExtraTurn() : Boolean

    fun seeFront()
}