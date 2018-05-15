package com.company.forest

import com.company.forest.organisms.animals.Animal
import com.company.forest.organisms.animals.AnimalFactory
import com.company.forest.util.Random
import javafx.scene.paint.Color

class PlaceWithoutTree: Place() {
    var animal: Animal? = null

    fun updateColor() {
        when(animal) {
            null -> color = Color.LIGHTGRAY
            else -> color = animal!!.color
        }
    }

    init {
        if (Random.happenWithChance(3)) {
            animal = AnimalFactory.getRandomAnimal()
        }
        updateColor()
    }
}