package com.company.experimental.animal

import com.company.forest.Place

abstract class BaseAnimalBehavior : Animal {
    lateinit var herald: AnimalData.AnimalHerald

    override fun associateWith(herald: AnimalData.AnimalHerald) {
        this.herald = herald
    }

    override fun goAhead() {
        herald.goAhead()
    }

    override fun rotateRightHand(right: Boolean) {
        herald.rotateRightHand(right)
    }

    override fun eat(place: Place) {
        herald.eat(place)
    }

    override fun fight(place: Place) {
        herald.fight(place)
    }

    override fun regenerate() {
        herald.regenerate()
    }

    override fun reproduce(place: Place) {
        herald.reproduce(place)
    }

    override fun askExtraTurn() {
        herald.askExtraTurn()
    }
}