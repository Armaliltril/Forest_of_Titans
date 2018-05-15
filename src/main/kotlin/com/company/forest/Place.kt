package com.company.forest

import com.company.forest.organisms.animals.Animal
import com.company.forest.organisms.animals.AnimalFactory
import com.company.forest.organisms.animals.ExampleHerbivorous
import javafx.scene.paint.Color
import java.util.*

@InProgress class Place {
    //color of place is color of animal within or light gray if none
    var color = Color.LIGHTGRAY
    var animal: Animal? = null

    fun updateColor() {
        when(animal) {
            null -> color = Color.LIGHTGRAY
            else -> color = animal!!.color
        }
    }

    init {
        if (Random().nextInt(10) in 0..2) {
            animal = AnimalFactory.getRandomAnimal()
        }
    }
}
