package com.company.forest

import com.company.forest.organisms.animal.AnimalData
import javafx.scene.paint.Color

class PlaceWithoutTree(var animal: AnimalData?): Place() {

    override var color = Color.WHITE!!

    fun updateColor() {
        color = when(animal) {
            null -> Color.WHITE
            else -> animal!!.behavior.getColor()
        }
    }

    init {
        updateColor()
    }
}