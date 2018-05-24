package com.company.experimental.animal

import com.company.experimental.Rotations
import com.company.forest.Place

abstract class BaseAnimalBehavior : Animal {
    private lateinit var herald: AnimalData.AnimalHerald

    override fun associateWith(herald: AnimalData.AnimalHerald) {
        this.herald = herald
    }

    override fun goAhead() = herald.goAhead()

    override fun turnAround(rotation: Rotations) = herald.turnAround(rotation)

    override fun eat() = herald.eat()

    override fun fight(otherAnimal: AnimalData) = herald.fight(otherAnimal)

    override fun regenerate() = herald.regenerate()

    override fun reproduce(otherAnimal: AnimalData) = herald.reproduce(otherAnimal)

    override fun askExtraTurn() = herald.askExtraTurn()

    override fun seeFront() = herald.seeFront()
}