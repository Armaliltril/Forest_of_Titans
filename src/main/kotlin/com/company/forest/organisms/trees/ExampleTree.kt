package com.company.forest.organisms.trees

import com.company.forest.InProgress
import javafx.scene.paint.Color

class ExampleTree(): Tree() {
    override val color = Color.BROWN
    override val maxAge = 100000
    override val maxHealth = 1000
    @InProgress override fun eat() {

    }

}