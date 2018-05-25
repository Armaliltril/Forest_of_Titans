package com.company.forest.organisms.animal

import javafx.scene.paint.Color

interface Animal: AnimalBehavior {
    fun associateWith(herald: AnimalData.AnimalHerald)

    fun tick()

    fun getType() : AnimalType

    fun getColor() : Color

    fun createData(x: Int, y: Int) = getType().createData(this, x, y)
}