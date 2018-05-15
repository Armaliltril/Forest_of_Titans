package com.company.forest.util

import com.company.forest.Forest
import com.company.forest.InProgress
import com.company.forest.organisms.animals.Animal
import com.company.forest.organisms.trees.Tree

@InProgress
object Observer {
    inline fun <reified T: Animal> countAnimals(): Int {
        var counter = 0
        Forest.places.forEach { it.forEach { if (it.animal is T) counter++} }
        return counter;
    }
}