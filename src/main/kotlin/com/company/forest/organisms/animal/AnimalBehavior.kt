package com.company.forest.organisms.animal

import com.company.forest.organisms.Rotations


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