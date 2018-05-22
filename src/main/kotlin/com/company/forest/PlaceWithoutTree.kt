package com.company.forest

import com.company.experimental.animal.Animal
import com.company.experimental.animal.AnimalData
import com.company.experimental.animal.example.StupidAnimal
import com.company.forest.util.Random
import javafx.scene.paint.Color

class PlaceWithoutTree(var animal: AnimalData?): Place() {

    override var color = Color.WHITE

    fun updateColor() {
        when(animal) {
            null -> color = Color.WHITE
            else -> color = animal!!.behavior.getColor()
        }
    }

    init {
        updateColor()
    }
}