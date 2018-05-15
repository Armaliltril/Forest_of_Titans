package com.company.forest.organisms

import com.company.forest.IDrawable
import com.company.forest.IRemovable
import com.company.forest.InProgress
import javafx.scene.paint.Color
import kotlin.math.roundToInt

abstract class Organism: IRemovable, IDrawable {
    abstract val maxHealth: Int
    abstract val maxAge: Int

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

    override fun tryRemove() {
        if (health <= 0) super.tryRemove()
    }

    init {
        health = 0
        age = 0
        hunger = 0
    } //TODO() proper initialization
}