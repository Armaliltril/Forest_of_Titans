package com.company.forest.organisms.trees

import com.company.forest.InProgress
import javafx.scene.paint.Color

class ExampleTree(): Tree() {
    override val color = Color.YELLOW
    override val maxAge = 100000
    override val maxHealth = 1000
    override val name = "Example Tree"
    @InProgress override fun eat() {

    }

}