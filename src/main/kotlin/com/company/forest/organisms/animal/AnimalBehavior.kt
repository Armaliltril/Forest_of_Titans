package com.company.forest.organisms.animal

import com.company.forest.organisms.Rotations


interface AnimalBehavior{

    fun goAhead() : Boolean
    fun turnAround(rotation: Rotations): Boolean
    fun seeFront()
    fun askExtraTurn() : Boolean

    fun eat() : Boolean
    fun fight(otherAnimal: AnimalData) : Boolean
    fun rest() : Boolean
    fun reproduce(otherAnimal: AnimalData) : Boolean

    fun isHungry(percent: Int): Boolean
    fun isDamaged(percent: Int): Boolean
    fun isTired(percent: Int): Boolean
}