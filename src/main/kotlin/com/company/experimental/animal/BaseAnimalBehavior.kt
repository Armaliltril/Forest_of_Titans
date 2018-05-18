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

    override fun seeEnemies() = herald.seeEnemies()

    override fun eat(place: Place) = herald.eat(place)

    override fun fight(place: Place) = herald.fight(place)

    override fun regenerate() = herald.regenerate()

    override fun reproduce(place: Place) = herald.reproduce(place)

    override fun askExtraTurn() = herald.askExtraTurn()

    override fun seeFood() = herald.seeFood()

    override fun seeFriends() = herald.seeFriends()
}