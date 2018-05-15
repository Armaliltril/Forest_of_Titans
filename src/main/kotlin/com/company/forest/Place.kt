package com.company.forest

import com.company.forest.organisms.animals.Animal
import com.company.forest.organisms.animals.AnimalFactory
import com.company.forest.organisms.animals.ExampleHerbivorous
import com.company.forest.organisms.trees.Tree
import com.company.forest.util.Random
import javafx.scene.paint.Color

@InProgress open class Place {
    //color of place is color of animal within or light gray if none
    open var color = Color.LIGHTGRAY
}
