package com.company.forest.organisms.animals

import com.company.forest.InProgress
import com.company.forest.organisms.IHerbivorous
import javafx.scene.paint.Color

class ExampleHerbivorous(): Animal(), IHerbivorous {
    override val power = 100
    override val maxHealth = 100
    override val maxAge = 100000
    override val color = Color.GREEN

    @InProgress override fun eat() {

    }

}