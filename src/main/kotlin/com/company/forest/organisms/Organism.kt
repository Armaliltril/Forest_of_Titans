package com.company.forest.organisms

import com.company.forest.InProgress
import javafx.scene.paint.Color
import kotlin.math.roundToInt

abstract class Organism {
    abstract val maxHealth: Int
    abstract val maxAge: Int
    abstract val color: Color

    var health: Int
    var age: Int
    var hunger: Int

    abstract fun eat()

    @InProgress fun grow() {
        age++
    }
    @InProgress fun regenerate() {
        health = ((health * 0.1) % maxHealth).roundToInt()
    }
    @InProgress fun makeDead() {

    }

    init {
        health = 0
        age = 0
        hunger = 0
    } //TODO() proper initialization
}