package com.company.experimental

import com.company.forest.Place

interface Animal: AnimalBehavior{
    fun associateWith(herald: AnimalData.Herald)

    fun tick()

    fun getType() : AnimalType
    fun createData() = getType().createData(this)
}

interface AnimalBehavior{
    fun move(place: Place)

    fun eat(place: Place)

    fun fight(place: Place)

    fun regenerate()

    fun reproduce(place: Place)

    fun askExtraTurn()
}