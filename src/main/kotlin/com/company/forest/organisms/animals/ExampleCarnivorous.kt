package com.company.forest.organisms.animals

import com.company.forest.InProgress
import com.company.forest.organisms.ICarnivorous
import javafx.scene.paint.Color

class ExampleCarnivorous: Animal(), ICarnivorous {
    override val power = 100
    override val maxHealth = 100
    override val maxAge = 100000
    override val color = Color.RED
    override val name = "Example Carnivorous"

    @InProgress override fun eat() {

    }
}